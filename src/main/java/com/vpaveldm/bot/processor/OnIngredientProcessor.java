package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnIngredientMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OnIngredientProcessor implements InlineKeyboardButtonProcessor {
    private final IngredientRepository ingredientRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean supports(String message) {
        int dots = message.indexOf(":");
        String category = message.substring(dots + 1);
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().anyMatch(ingredient -> ingredient.getName().endsWith(category));
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        int dots = query.getData().indexOf(":");

        String categoryName = query.getData().substring(0, dots);
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (!category.isPresent()) {
            return;
        }

        String ingredientName = query.getData().substring(dots + 1);
        Set<Item> items = itemRepository.findByCategory(category.get());
        Set<Ingredient> allIngredients = items
                .stream()
                .map(Item::getIngredients)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        Optional<Ingredient> ingredient = allIngredients
                .stream()
                .filter(fIngredient -> fIngredient.getName().equals(ingredientName))
                .findFirst();
        if (!ingredient.isPresent()) {
            return;
        }

        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }

        Set<Ingredient> choseIngredients = user.get().getChoseIngredients();
        if (!choseIngredients.add(ingredient.get())) {
            choseIngredients.remove(ingredient.get());
        }
        userRepository.save(user.get());

        getExecute(sender, new OnIngredientMessage(allIngredients, choseIngredients, categoryName).get(query.getMessage()));
    }
}

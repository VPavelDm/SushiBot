package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.MessageIDs;
import com.vpaveldm.bot.message.OnIngredientMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OnAllIngredientProcessor implements InlineKeyboardButtonProcessor {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean supports(String message) {
        return message.endsWith(MessageIDs.ALL_INGREDIENTS.getID());
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        int dots = query.getData().indexOf(":");
        String categoryName = query.getData().substring(0, dots);
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (!category.isPresent()) {
            return;
        }

        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }

        Set<Ingredient> choseIngredients = user.get().getChoseIngredients();
        Set<Ingredient> ingredients = itemRepository.findByCategory(category.get())
                .stream()
                .map(Item::getIngredients)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        choseIngredients.addAll(ingredients);
        userRepository.save(user.get());

        getExecute(sender, new OnIngredientMessage(ingredients, choseIngredients, categoryName).get(query.getMessage()));
    }
}

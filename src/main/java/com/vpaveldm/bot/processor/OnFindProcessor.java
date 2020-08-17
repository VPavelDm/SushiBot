package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class OnFindProcessor implements InlineKeyboardButtonProcessor {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public boolean supports(String message) {
        return message.endsWith(Messages.FIND);
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
        Set<Ingredient> ingredients = user.get().getChoseIngredients();
        if (ingredients.isEmpty()) {
            ingredients.addAll(ingredientRepository.findAllByCategory(category.get()));
        }

        List<Item> items = itemRepository.findDistinctByCategoryAndIngredientsIn(category.get(), ingredients);

        Basket basket = user.get().getBasket();
        for (Item item : items) {
            Long count = basket.getItems()
                    .stream()
                    .filter(basketItem -> basketItem.getId().equals(item.getId()))
                    .count();
            getExecute(sender, new OnFindMessage(item, count).get(query.getMessage()));
        }
    }
}

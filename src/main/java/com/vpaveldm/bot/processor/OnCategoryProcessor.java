package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnCategoryMessage;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class OnCategoryProcessor implements ReplyKeyboardButtonProcessor {
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean supports(String message) {
        return categoryRepository.findAll().stream().anyMatch(category -> category.getName().equals(message));
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        List<Category> categories = categoryRepository.findAllByName(message.getText());
        Category category = categories.get(0);
        List<Ingredient> ingredients = ingredientRepository.findAllByCategory(category);
        if (ingredients.isEmpty()) {
            userRepository.findUserByTelegramId(message.getFrom().getId().longValue())
                    .ifPresent(user -> {
                        List<Item> items = itemRepository.findDistinctByCategory(category);

                        Basket basket = user.getBasket();
                        for (Item item : items) {
                            Long count = basket.getItems()
                                    .stream()
                                    .filter(basketItem -> basketItem.getId().equals(item.getId()))
                                    .count();
                            getExecute(sender, new OnFindMessage(item, count).get(message));
                        }
                    });
        } else {
            Set<Ingredient> choseIngredients = userRepository
                    .findUserByTelegramId(message.getFrom().getId().longValue())
                    .map(User::getChoseIngredients)
                    .orElse(Collections.emptySet());
            getExecute(sender, new OnCategoryMessage(ingredients, choseIngredients).get(message));
        }
    }
}

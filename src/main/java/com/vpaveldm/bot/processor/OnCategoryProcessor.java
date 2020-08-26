package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnCategoryMessage;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OnCategoryProcessor implements ReplyKeyboardButtonProcessor {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public boolean supports(String message) {
        return categoryRepository.findAll().stream().anyMatch(category -> category.getName().equals(message));
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        if (!message.hasText()) {
            return;
        }
        Optional<Category> category = categoryRepository.findByName(message.getText());
        if (!category.isPresent()) {
            return;
        }
        Set<Item> items = itemRepository.findByCategory(category.get());
        Set<Ingredient> ingredients = items
                .stream()
                .map(Item::getIngredients)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        if (ingredients.isEmpty()) {
            Set<BasketItem> basketItems = userRepository.findUserByTelegramId(message.getFrom().getId().longValue())
                    .map(User::getBasket)
                    .map(Basket::getBasketItems)
                    .orElse(Collections.emptySet());
            for (Item item : items) {
                Long count = basketItems
                        .stream()
                        .filter(basketItem -> basketItem.getItem().equals(item))
                        .findFirst()
                        .map(BasketItem::getCount)
                        .orElse(0L);
                getExecute(sender, new OnFindMessage(item, count).get(message));
            }
        } else {
            Set<Ingredient> choseIngredients = userRepository
                    .findUserByTelegramId(message.getFrom().getId().longValue())
                    .map(User::getChoseIngredients)
                    .orElse(Collections.emptySet());
            OnCategoryMessage categoryMessage = new OnCategoryMessage(
                    ingredients,
                    choseIngredients,
                    category.get().getName()
            );
            getExecute(sender, categoryMessage.get(message));
        }
    }
}

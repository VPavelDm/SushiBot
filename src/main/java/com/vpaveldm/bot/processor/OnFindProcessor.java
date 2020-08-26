package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.MessageIDs;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OnFindProcessor implements InlineKeyboardButtonProcessor {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public boolean supports(String message) {
        return message.endsWith(MessageIDs.FIND.getID());
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
            Set<Ingredient> allIngredients = itemRepository.findByCategory(category.get())
                    .stream()
                    .map(Item::getIngredients)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
            ingredients.addAll(allIngredients);
        }

        Set<Item> items = itemRepository.findByCategoryAndIngredientsIn(category.get(), ingredients);

        Set<BasketItem> basketItems = user
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
            getExecute(sender, new OnFindMessage(item, count).get(query.getMessage()));
        }
    }
}

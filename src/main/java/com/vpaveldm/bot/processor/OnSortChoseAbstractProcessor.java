package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class OnSortChoseAbstractProcessor implements InlineKeyboardButtonProcessor {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }

        int dots = query.getData().indexOf(":");
        String categoryName = query.getData().substring(0, dots);
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (!category.isPresent()) {
            return;
        }

        Set<Ingredient> choseIngredients = user.get().getChoseIngredients();
        if (choseIngredients.isEmpty()) {
            Set<Ingredient> allIngredients = itemRepository.findByCategory(category.get())
                    .stream()
                    .map(Item::getIngredients)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toSet());
            choseIngredients.addAll(allIngredients);
        }

        List<Item> items = itemRepository.findByCategoryAndIngredientsIn(category.get(), choseIngredients)
                .stream()
                .sorted(getComparator())
                .collect(Collectors.toList());
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

    abstract Comparator<Item> getComparator();
}

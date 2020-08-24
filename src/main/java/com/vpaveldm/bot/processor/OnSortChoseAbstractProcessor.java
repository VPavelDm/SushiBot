package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.*;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class OnSortChoseAbstractProcessor implements InlineKeyboardButtonProcessor {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;

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
            choseIngredients.addAll(ingredientRepository.findAllByCategory(category.get()));
        }

        List<Item> items = itemRepository.findDistinctByCategoryAndIngredientsIn(category.get(), choseIngredients)
                .stream()
                .sorted(getComparator())
                .collect(Collectors.toList());
        Basket basket = user.get().getBasket();
        for (Item item : items) {
            Long count = basket.getItems()
                    .stream()
                    .filter(basketItem -> basketItem.getId().equals(item.getId()))
                    .count();
            getExecute(sender, new OnFindMessage(item, count).get(query.getMessage()));
        }
    }

    abstract Comparator<Item> getComparator();
}

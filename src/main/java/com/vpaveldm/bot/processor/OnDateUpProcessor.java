package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OnDateUpProcessor extends OnSortChoseAbstractProcessor {
    public OnDateUpProcessor(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository, IngredientRepository ingredientRepository) {
        super(itemRepository, userRepository, categoryRepository, ingredientRepository);
    }

    @Override
    Comparator<Item> getComparator() {
        return Comparator.comparing(Item::getDate);
    }

    @Override
    public boolean supports(String message) {
        return message.endsWith(Messages.NEWEST);
    }
}

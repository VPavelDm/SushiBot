package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.ItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OnPriceDownProcessor extends OnSortChoseAbstractProcessor {
    public OnPriceDownProcessor(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        super(itemRepository, userRepository, categoryRepository);
    }

    @Override
    Comparator<Item> getComparator() {
        return (o1, o2) -> o2.getPrice().compareTo(o1.getPrice());
    }

    @Override
    public boolean supports(String message) {
        return message.endsWith(Messages.PRICE_DOWN);
    }
}

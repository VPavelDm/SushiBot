package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnBasketMessage;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.Basket;
import com.vpaveldm.database.model.BasketItem;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class OnBasketProcessor implements ReplyKeyboardButtonProcessor {
    private final UserRepository userRepository;

    @Override
    public boolean supports(String message) {
        return message.equals(Messages.BASKET);
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        getExecute(sender, new OnBasketMessage().get(message));
        Set<BasketItem> basketItems = userRepository.findUserByTelegramId(message.getFrom().getId().longValue())
                .map(User::getBasket)
                .map(Basket::getBasketItems)
                .orElse(Collections.emptySet());
        Set<Item> items = basketItems
                .stream()
                .map(BasketItem::getItem)
                .collect(Collectors.toSet());
        for (Item item : items) {
            Long count = basketItems
                    .stream()
                    .filter(basketItem -> basketItem.getItem().equals(item))
                    .findFirst()
                    .map(BasketItem::getCount)
                    .orElse(0L);
            if (count != 0) {
                getExecute(sender, new OnFindMessage(item, count).get(message));
            }
        }
    }
}

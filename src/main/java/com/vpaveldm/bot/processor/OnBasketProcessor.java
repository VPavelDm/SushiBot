package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnBasketMessage;
import com.vpaveldm.bot.message.OnFindMessage;
import com.vpaveldm.database.model.Basket;
import com.vpaveldm.database.model.Item;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Collections;
import java.util.List;
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
        List<Item> items = userRepository.findUserByTelegramId(message.getFrom().getId().longValue())
                .map(User::getBasket)
                .map(Basket::getItems)
                .orElse(Collections.emptyList());
        List<Item> distinctItems = items.stream()
                .distinct()
                .collect(Collectors.toList());
        for (Item item : distinctItems) {
            Long count = items
                    .stream()
                    .filter(basketItem -> basketItem.getId().equals(item.getId()))
                    .count();
            getExecute(sender, new OnFindMessage(item, count).get(message));
        }
    }
}

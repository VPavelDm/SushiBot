package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.WelcomeMessage;
import com.vpaveldm.database.model.Basket;
import com.vpaveldm.database.model.BasketItem;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.model.UserState;
import com.vpaveldm.database.repository.BasketItemRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StartCommandProcessor implements ReplyKeyboardButtonProcessor {
    private final UserRepository repository;
    private final BasketItemRepository basketItemRepository;
    @Override
    public boolean supports(String message) {
        return message.equals("/start");
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        Optional<User> user = repository.findUserByTelegramId(message.getFrom().getId().longValue());
        if (user.isPresent()) {
            Set<BasketItem> basketItems = user.get().getBasket().getBasketItems()
                    .stream()
                    .filter(bi -> bi.getCount() > 0)
                    .collect(Collectors.toSet());
            for (BasketItem basketItem : basketItems) {
                basketItem.setCount(0L);
            }
            if (basketItems.size() > 0) {
                basketItemRepository.saveAll(basketItems);
            }
        } else {
            Basket basket = Basket.builder().build();
            user = Optional.ofNullable(User.builder()
                    .chatId(message.getChatId())
                    .telegramId(message.getFrom().getId().longValue())
                    .username(message.getFrom().getUserName())
                    .basket(basket)
                    .state(UserState.DEFAULT)
                    .build());
            user.ifPresent(repository::save);
        }
        getExecute(sender, new WelcomeMessage().get(message));
    }
}

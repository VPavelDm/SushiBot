package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnAddressEnteredMessage;
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

@Component
@AllArgsConstructor
public class OnAddressProcessor implements TextMessageProcessor {
    private final UserRepository userRepository;
    private final BasketItemRepository basketItemRepository;

    @Override
    public boolean supports(Message message) {
        Optional<User> user = userRepository.findUserByTelegramId(message.getFrom().getId().longValue());
        return user.map(value -> value.getState().equals(UserState.ADDRESS)).orElse(false);
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        Optional<User> user = userRepository.findUserByTelegramId(message.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }
        user.get().setState(UserState.DEFAULT);
        userRepository.save(user.get());

        if (!message.hasText()) {
            return;
        }
        String address = message.getText();
        getExecute(sender, new OnAddressEnteredMessage(address).get(message));
        clearBasket(user.get());
    }

    private void clearBasket(User user) {
        Set<BasketItem> basketItemSet = user.getBasket()
                .getBasketItems();
        for (BasketItem basketItem : basketItemSet) {
            basketItem.setCount(0L);
        }
        basketItemRepository.saveAll(basketItemSet);
    }
}

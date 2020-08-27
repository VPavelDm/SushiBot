package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnMakeOrderMessage;
import com.vpaveldm.bot.message.OnMakeOrderPriceMessage;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.model.UserState;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.text.DecimalFormat;
import java.util.Optional;

@Component
@AllArgsConstructor
public class OnMakeOrderProcessor implements ReplyKeyboardButtonProcessor {
    private final UserRepository userRepository;

    @Override
    public boolean supports(String message) {
        return message.equals(Messages.MAKE_ORDER);
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        Optional<User> user = userRepository.findUserByTelegramId(message.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }

        user.get().setState(UserState.ADDRESS);
        userRepository.save(user.get());

        Double price = user.get().getBasket().getBasketItems()
                .stream()
                .map(basketItem -> basketItem.getCount() * basketItem.getItem().getPrice())
                .reduce(0.0, Double::sum);
        DecimalFormat df = new DecimalFormat("#.##");
        price = Double.valueOf(df.format(price));
        getExecute(sender, new OnMakeOrderPriceMessage(price).get(message));
        getExecute(sender, new OnMakeOrderMessage().get(message));
    }

}

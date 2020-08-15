package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.WelcomeMessage;
import com.vpaveldm.database.model.Basket;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.model.UserState;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StartCommandProcessor implements ReplyKeyboardButtonProcessor {
    private final UserRepository repository;
    @Override
    public boolean supports(String message) {
        return message.equals("/start");
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        Optional<User> user = repository.findUserByTelegramId(message.getFrom().getId().longValue());
        if (!user.isPresent()) {
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

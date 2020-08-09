package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.WelcomeMessage;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

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
        User user = User.builder()
                .chatId(message.getChatId())
                .telegramId(message.getFrom().getId().longValue())
                .username(message.getFrom().getUserName())
                .build();
        repository.save(user);
        getExecute(sender, new WelcomeMessage().get(message));
    }
}

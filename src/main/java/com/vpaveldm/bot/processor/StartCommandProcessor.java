package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.WelcomeMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class StartCommandProcessor implements KeyboardButtonProcessor {
    @Override
    public boolean supports(String message) {
        return message.equals("/start");
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        getExecute(sender, new WelcomeMessage().get(message));
    }
}

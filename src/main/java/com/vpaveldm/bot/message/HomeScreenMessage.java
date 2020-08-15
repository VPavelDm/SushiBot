package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class HomeScreenMessage implements TextMessage {
    @Override
    public SendMessage get(Message message) {
        return new WelcomeMessage().get(message)
                .setText(Messages.HOME_SCREEN_MESSAGE);
    }
}

package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class OnMakeOrderMessage implements TextMessage {
    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.ENTER_ADDRESS)
                .setParseMode("html");
    }
}

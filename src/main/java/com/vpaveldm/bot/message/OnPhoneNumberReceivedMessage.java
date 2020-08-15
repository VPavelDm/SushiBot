package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class OnPhoneNumberReceivedMessage implements TextMessage {
    @Override
    public SendMessage get(Message message) {
        ReplyKeyboard markup = new OnBasketMessage().get(message).getReplyMarkup();
        return new SendMessage(message.getChatId(), Messages.PHONE_NUMBER_RECEIVED)
                .setParseMode("html")
                .setReplyMarkup(markup);
    }
}

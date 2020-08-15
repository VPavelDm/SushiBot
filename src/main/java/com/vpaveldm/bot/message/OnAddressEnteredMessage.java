package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@AllArgsConstructor
public class OnAddressEnteredMessage implements TextMessage {
    private final String address;

    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.ADDRESS_ENTERED_MESSAGE + address)
                .setParseMode("html");
    }
}

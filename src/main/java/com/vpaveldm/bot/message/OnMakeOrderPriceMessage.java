package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@AllArgsConstructor
public class OnMakeOrderPriceMessage implements TextMessage {
    private final Double price;
    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.MAKE_ORDER_PRICE + price)
                .setParseMode("html");
    }
}

package com.vpaveldm.bot.message;

import com.vpaveldm.database.model.Item;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@AllArgsConstructor
public class OnAmountMessage implements EditMessageCaptionMessage {
    private final Item item;
    private final Long count;
    @Override
    public EditMessageCaption get(Message message) {
        SendPhoto onFindMessage = new OnFindMessage(item, count).get(message);
        return new EditMessageCaption()
                .setParseMode("html")
                .setMessageId(message.getMessageId())
                .setChatId(String.valueOf(message.getChatId()))
                .setCaption(onFindMessage.getCaption())
                .setReplyMarkup((InlineKeyboardMarkup) onFindMessage.getReplyMarkup());
    }
}

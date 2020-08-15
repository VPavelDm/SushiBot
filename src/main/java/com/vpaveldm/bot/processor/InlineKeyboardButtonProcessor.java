package com.vpaveldm.bot.processor;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface InlineKeyboardButtonProcessor {
    boolean supports(String message);

    void processMessage(AbsSender sender, CallbackQuery query);

    @SneakyThrows
    default Message getExecute(AbsSender sender, SendMessage sendMessage) {
        return sender.execute(sendMessage);
    }

    @SneakyThrows
    default void getExecute(AbsSender sender, EditMessageReplyMarkup editMessageReplyMarkup) {
         sender.execute(editMessageReplyMarkup);
    }

    @SneakyThrows
    default void getExecute(AbsSender sender, EditMessageCaption editMessageCaption) {
        sender.execute(editMessageCaption);
    }

    @SneakyThrows
    default void getExecute(AbsSender sender, SendPhoto sendPhoto) {
        sender.execute(sendPhoto);
    }
}

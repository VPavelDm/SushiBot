package com.vpaveldm.bot.processor;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface InlineKeyboardButtonProcessor {
    boolean supports(CallbackQuery inlineKeyboardButton);

    void processMessage(AbsSender sender, CallbackQuery callbackQuery);

    @SneakyThrows
    default Message getExecute(AbsSender sender, SendMessage sendMessage) {
        return sender.execute(sendMessage);
    }
}

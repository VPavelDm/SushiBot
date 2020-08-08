package com.vpaveldm.bot.processor;

import lombok.SneakyThrows;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface KeyboardButtonProcessor {
    boolean supports(String message);

    void processMessage(AbsSender sender, Message message);

    @SneakyThrows
    default Message getExecute(AbsSender sender, SendMessage sendMessage) {
        return sender.execute(sendMessage);
    }
}

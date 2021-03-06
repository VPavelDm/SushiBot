package com.vpaveldm.bot.processor;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface ReplyKeyboardButtonProcessor extends KeyboardButtonProcessor {
    boolean supports(String message);

    void processMessage(AbsSender sender, Message message);
}

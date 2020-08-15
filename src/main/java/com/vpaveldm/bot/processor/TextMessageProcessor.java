package com.vpaveldm.bot.processor;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface TextMessageProcessor extends KeyboardButtonProcessor {
    boolean supports(Message message);

    void processMessage(AbsSender sender, Message message);
}

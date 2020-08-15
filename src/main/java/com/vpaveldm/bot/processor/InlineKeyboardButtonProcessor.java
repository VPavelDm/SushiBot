package com.vpaveldm.bot.processor;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface InlineKeyboardButtonProcessor extends KeyboardButtonProcessor {
    void processMessage(AbsSender sender, CallbackQuery query);
}

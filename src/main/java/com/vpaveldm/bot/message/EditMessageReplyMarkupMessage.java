package com.vpaveldm.bot.message;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface EditMessageReplyMarkupMessage {
    EditMessageReplyMarkup get(Message message);
}

package com.vpaveldm.bot.message;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface EditMessageCaptionMessage {
    EditMessageCaption get(Message message);
}

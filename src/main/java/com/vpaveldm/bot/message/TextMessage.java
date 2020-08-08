package com.vpaveldm.bot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface TextMessage {
    SendMessage get(Message message);
}

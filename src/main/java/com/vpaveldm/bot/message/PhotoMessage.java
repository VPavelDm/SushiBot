package com.vpaveldm.bot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface PhotoMessage {
    SendPhoto get(Message message);
}

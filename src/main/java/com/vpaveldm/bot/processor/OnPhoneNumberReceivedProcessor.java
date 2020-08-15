package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnPhoneNumberReceivedMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class OnPhoneNumberReceivedProcessor implements PhoneNumberProcessor {
    @Override
    public boolean supports(Message message) {
        return message.hasContact();
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        getExecute(sender, new OnPhoneNumberReceivedMessage().get(message));
    }
}

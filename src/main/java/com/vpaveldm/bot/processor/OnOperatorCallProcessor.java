package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnOperatorCallMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class OnOperatorCallProcessor implements ReplyKeyboardButtonProcessor {
    @Override
    public boolean supports(String message) {
        return message.equals(Messages.HELP);
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        getExecute(sender, new OnOperatorCallMessage().get(message));
    }
}

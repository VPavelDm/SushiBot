package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class OnBasketMessage implements TextMessage {
    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.BASKET_MESSAGE)
                .setParseMode("html")
                .setReplyMarkup(getKeyboard());
    }

    private ReplyKeyboardMarkup getKeyboard() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton makeOrder = new KeyboardButton(Messages.MAKE_ORDER);
        KeyboardButton help = new KeyboardButton(Messages.HELP);
        row1.add(makeOrder);
        row1.add(help);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton back = new KeyboardButton(Messages.HOME_SCREEN);
        row2.add(back);

        keyboard.add(row1);
        keyboard.add(row2);

        markup.setKeyboard(keyboard);

        return markup;
    }
}

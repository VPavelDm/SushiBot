package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class WelcomeMessage implements TextMessage {
    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.WELCOME)
                .setParseMode("html")
                .setReplyMarkup(getKeyboard());
    }

    private ReplyKeyboardMarkup getKeyboard() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardRow> keyboard = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton categories = new KeyboardButton(Messages.CATEGORIES);
        KeyboardButton basket = new KeyboardButton(Messages.BASKET);

        row.add(categories);
        row.add(basket);
        keyboard.add(row);

        markup.setKeyboard(keyboard);

        return markup;
    }
}

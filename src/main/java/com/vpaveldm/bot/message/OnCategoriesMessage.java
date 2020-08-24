package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Category;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OnCategoriesMessage implements TextMessage {
    private final List<Category> categories;

    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.ON_CATEGORIES)
                .setParseMode("html")
                .setReplyMarkup(getKeyboard());
    }

    private ReplyKeyboardMarkup getKeyboard() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);

        List<KeyboardButton> buttons = categories
                .stream()
                .map(category -> new KeyboardButton(category.getName()))
                .collect(Collectors.toList());

        List<KeyboardRow> keyboard = new ArrayList<>();
        for (int i = 0; i < buttons.size(); i += 2) {
            KeyboardRow row = new KeyboardRow();
            row.add(buttons.get(i));
            if (i + 1 < buttons.size()) {
                row.add(buttons.get(i + 1));
            }
            keyboard.add(row);
        }
        KeyboardRow backRow = new KeyboardRow();
        KeyboardButton back = new KeyboardButton(Messages.HOME_SCREEN);
        backRow.add(back);
        keyboard.add(backRow);

        markup.setKeyboard(keyboard);

        return markup;
    }
}

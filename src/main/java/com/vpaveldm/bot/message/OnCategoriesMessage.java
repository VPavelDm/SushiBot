package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Category;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

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

        List<KeyboardRow> keyboard = categories
                .stream()
                .map(category -> new KeyboardButton(category.getName()))
                .map(button -> {
                    KeyboardRow row = new KeyboardRow();
                    row.add(button);
                    return row;
                })
                .collect(Collectors.toList());

        markup.setKeyboard(keyboard);

        return markup;
    }
}

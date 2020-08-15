package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Item;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OnFindMessage implements PhotoMessage {
    private final Item item;
    private final Long count;

    @Override
    public SendPhoto get(Message message) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(item.getPhotoURL());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new SendPhoto()
                .setParseMode("html")
                .setCaption(prepareCaption())
                .setChatId(message.getChatId())
                .setPhoto("Photo", stream)
                .setReplyMarkup(getKeyboard());
    }

    private String prepareCaption() {
        String result = "<b>" + item.getName() + "</b>";
        if (item.getDescription() != null) {
            result += "\nСостав: <i>" + item.getDescription() + "</i>";
        }
        return result
                + "\nЦена: " + item.getPrice()
                + "\nВ корзине: " + count;
    }

    private InlineKeyboardMarkup getKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton more = new InlineKeyboardButton(Messages.MORE)
                .setCallbackData(item.getCategory().getName() + ":" + item.getId()  + ":" + Messages.MORE);
        InlineKeyboardButton less = new InlineKeyboardButton(Messages.LESS)
                .setCallbackData(item.getCategory().getName() + ":" + item.getId() + ":" + Messages.LESS);
        row.add(more);
        row.add(less);
        keyboard.add(row);

        markup.setKeyboard(keyboard);

        return markup;
    }
}

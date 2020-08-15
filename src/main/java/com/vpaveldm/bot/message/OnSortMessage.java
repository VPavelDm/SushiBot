package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Category;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OnSortMessage implements TextMessage {
    private final Category category;
    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.ON_SORT_ORDER)
                .setParseMode("html")
                .setReplyMarkup(getKeyboard());
    }

    private InlineKeyboardMarkup getKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<String> orders = Arrays.asList(
                Messages.PRICE_UP, Messages.PRICE_DOWN,
                Messages.NEWEST
        );
        List<List<InlineKeyboardButton>> keyboard = orders.stream()
                .map(order -> new InlineKeyboardButton(order).setCallbackData(category.getName() + ":" + order))
                .map(Collections::singletonList)
                .collect(Collectors.toList());

        markup.setKeyboard(keyboard);

        return markup;
    }
}

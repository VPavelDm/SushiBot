package com.vpaveldm.bot.message;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.database.model.Ingredient;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OnCategoryMessage implements TextMessage {
    private final List<Ingredient> ingredients;
    private final Set<Ingredient> choseIngredients;

    @Override
    public SendMessage get(Message message) {
        return new SendMessage(message.getChatId(), Messages.ON_CATEGORY)
                .setParseMode("html")
                .setReplyMarkup(getKeyboard());
    }

    private InlineKeyboardMarkup getKeyboard() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        String category = ingredients.get(0).getCategory().getName();
        List<InlineKeyboardButton> buttons = ingredients
                .stream()
                .map(ingredient -> new InlineKeyboardButton(prepareName(ingredient))
                        .setCallbackData(category + ":" + ingredient.getName()))
                .collect(Collectors.toList());

        for (int i = 0; i < buttons.size(); i += 2) {
            List<InlineKeyboardButton> row = new ArrayList<>();
            row.add(buttons.get(i));
            if (i + 1 < buttons.size()) {
                row.add(buttons.get(i + 1));
            }
            keyboard.add(row);
        }

        InlineKeyboardButton all = new InlineKeyboardButton(Messages.ALL_INGREDIENTS)
                .setCallbackData(category + ":" + Messages.ALL_INGREDIENTS);
        InlineKeyboardButton reset = new InlineKeyboardButton(Messages.RESET_INGREDIENTS)
                .setCallbackData(category + ":" + Messages.RESET_INGREDIENTS);
        InlineKeyboardButton find = new InlineKeyboardButton(Messages.FIND)
                .setCallbackData(category + ":" + Messages.FIND);
        InlineKeyboardButton sort = new InlineKeyboardButton(Messages.SORT_ORDER_SETTINGS)
                .setCallbackData(category + ":" + Messages.SORT_ORDER_SETTINGS);

        keyboard.add(Arrays.asList(all, reset));
        keyboard.add(Collections.singletonList(find));
        keyboard.add(Collections.singletonList(sort));

        markup.setKeyboard(keyboard);

        return markup;
    }

    private String prepareName(Ingredient ingredient) {
        if (choseIngredients.contains(ingredient)) {
            return ingredient.getName() + " ✅";
        } else {
            return ingredient.getName();
        }
    }
}

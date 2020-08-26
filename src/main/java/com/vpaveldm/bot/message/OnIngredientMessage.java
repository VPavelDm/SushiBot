package com.vpaveldm.bot.message;

import com.vpaveldm.database.model.Ingredient;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Set;

@AllArgsConstructor
public class OnIngredientMessage implements EditMessageReplyMarkupMessage {
    private final Set<Ingredient> ingredients;
    private final Set<Ingredient> choseIngredients;
    private final String category;
    @Override
    public EditMessageReplyMarkup get(Message message) {
        OnCategoryMessage categoryMessage = new OnCategoryMessage(ingredients, choseIngredients, category);
        return new EditMessageReplyMarkup()
                .setChatId(message.getChatId())
                .setMessageId(message.getMessageId())
                .setReplyMarkup((InlineKeyboardMarkup) categoryMessage.get(message).getReplyMarkup());
    }
}

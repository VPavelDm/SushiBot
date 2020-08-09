package com.vpaveldm.bot.processor;

import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Component
@AllArgsConstructor
public class OnIngredientProcessor implements InlineKeyboardButtonProcessor {
    private final IngredientRepository repository;

    @Override
    public boolean supports(String message) {
        int dots = message.indexOf(":");
        String category = message.substring(dots + 1);
        List<Ingredient> ingredients = repository.findAll();
        return ingredients.stream().anyMatch(ingredient -> ingredient.getName().endsWith(category));
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
    }
}

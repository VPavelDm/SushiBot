package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.message.OnCategoryMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Component
@AllArgsConstructor
public class OnCategoryProcessor implements KeyboardButtonProcessor {
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public boolean supports(String message) {
        return categoryRepository.findAll().stream().anyMatch(category -> category.getName().equals(message));
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        List<Category> categories = categoryRepository.findByName(message.getText());
        Category category = categories.get(0);
        List<Ingredient> ingredients = ingredientRepository.findAllByCategory(category);
        getExecute(sender, new OnCategoryMessage(ingredients).get(message));
    }
}

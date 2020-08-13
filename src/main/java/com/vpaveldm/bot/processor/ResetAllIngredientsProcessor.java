package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnIngredientMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.User;
import com.vpaveldm.database.repository.CategoryRepository;
import com.vpaveldm.database.repository.IngredientRepository;
import com.vpaveldm.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class ResetAllIngredientsProcessor implements InlineKeyboardButtonProcessor {
    private final IngredientRepository ingredientRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public boolean supports(String message) {
        return message.endsWith(Messages.RESET_INGREDIENTS);
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        int dots = query.getData().indexOf(":");
        String categoryName = query.getData().substring(0, dots);
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (!category.isPresent()) {
            return;
        }

        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        if (!user.isPresent()) {
            return;
        }

        Set<Ingredient> choseIngredients = user.get().getChoseIngredients();
        List<Ingredient> ingredients = ingredientRepository.findAllByCategory(category.get());
        choseIngredients.removeAll(ingredients);
        userRepository.save(user.get());

        getExecute(sender, new OnIngredientMessage(ingredients, choseIngredients).get(query.getMessage()));
    }
}

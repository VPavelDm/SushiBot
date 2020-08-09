package com.vpaveldm.bot.processor;

import com.vpaveldm.database.model.Ingredient;
import com.vpaveldm.database.model.User;
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
public class OnIngredientProcessor implements InlineKeyboardButtonProcessor {
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;

    @Override
    public boolean supports(String message) {
        int dots = message.indexOf(":");
        String category = message.substring(dots + 1);
        List<Ingredient> ingredients = ingredientRepository.findAll();
        return ingredients.stream().anyMatch(ingredient -> ingredient.getName().endsWith(category));
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        Optional<User> user = userRepository.findUserByTelegramId(query.getFrom().getId().longValue());
        Ingredient ingredient = ingredientRepository.findAll().get(0);
        if (user.isPresent()) {
            Set<Ingredient> ingredientSet = user.get().getChoseIngredients();
            ingredientSet.add(ingredient);
            userRepository.save(user.get());
        }
    }
}

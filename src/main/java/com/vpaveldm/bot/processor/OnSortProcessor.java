package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.MessageIDs;
import com.vpaveldm.bot.message.OnSortMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OnSortProcessor implements InlineKeyboardButtonProcessor {
    private final CategoryRepository categoryRepository;
    @Override
    public boolean supports(String message) {
        return message.endsWith(MessageIDs.SORT_ORDER_SETTINGS.getID());
    }

    @Override
    public void processMessage(AbsSender sender, CallbackQuery query) {
        int dots = query.getData().indexOf(":");
        String categoryName = query.getData().substring(0, dots);
        Optional<Category> category = categoryRepository.findByName(categoryName);
        if (!category.isPresent()) {
            return;
        }

        getExecute(sender, new OnSortMessage(category.get()).get(query.getMessage()));
    }
}

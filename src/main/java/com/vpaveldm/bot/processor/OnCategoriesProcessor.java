package com.vpaveldm.bot.processor;

import com.vpaveldm.bot.constants.Messages;
import com.vpaveldm.bot.message.OnCategoriesMessage;
import com.vpaveldm.database.model.Category;
import com.vpaveldm.database.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Component
@AllArgsConstructor
public class OnCategoriesProcessor implements ReplyKeyboardButtonProcessor {

    private final CategoryRepository repository;

    @Override
    public boolean supports(String message) {
        return message.equals(Messages.CATEGORIES);
    }

    @Override
    public void processMessage(AbsSender sender, Message message) {
        List<Category> categories = repository.findAll();
        OnCategoriesMessage categoriesMessage = new OnCategoriesMessage(categories);
        getExecute(sender, categoriesMessage.get(message));
    }
}

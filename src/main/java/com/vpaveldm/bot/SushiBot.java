package com.vpaveldm.bot;

import com.vpaveldm.bot.processor.InlineKeyboardButtonProcessor;
import com.vpaveldm.bot.processor.ReplyKeyboardButtonProcessor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class SushiBot extends TelegramLongPollingBot {

    private final List<ReplyKeyboardButtonProcessor> processors;

    public SushiBot(List<ReplyKeyboardButtonProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            processors
                    .stream()
                    .filter(processor -> processor.supports(message))
                    .forEach(replyKeyboardButtonProcessor -> replyKeyboardButtonProcessor.processMessage(this, message));
        }
    }

    @Override
    public String getBotUsername() {
        return "Sushi Bot";
    }

    @Override
    public String getBotToken() {
        return "1079396731:AAHEweFNsGZEH9SfM4TDY8ziachw33MSmhU";
    }


}


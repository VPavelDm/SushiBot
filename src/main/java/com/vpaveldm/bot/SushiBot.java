package com.vpaveldm.bot;

import com.vpaveldm.bot.processor.KeyboardButtonProcessor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class SushiBot extends TelegramLongPollingBot {

    private final List<KeyboardButtonProcessor> processors;

    public SushiBot(List<KeyboardButtonProcessor> processors) {
        this.processors = processors;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text;
        Message message;
        if (update.hasMessage()) {
            text = update.getMessage().getText();
            message = update.getMessage();
        } else if (update.hasCallbackQuery()) {
            text = update.getCallbackQuery().getData();
            message = update.getCallbackQuery().getMessage();
        } else {
            return;
        }
        processors
                .stream()
                .filter(processor -> processor.supports(text))
                .forEach(keyboardButtonProcessor -> keyboardButtonProcessor.processMessage(this, message));
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


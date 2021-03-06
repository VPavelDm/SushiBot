package com.vpaveldm.bot;

import com.vpaveldm.bot.processor.InlineKeyboardButtonProcessor;
import com.vpaveldm.bot.processor.PhoneNumberProcessor;
import com.vpaveldm.bot.processor.ReplyKeyboardButtonProcessor;
import com.vpaveldm.bot.processor.TextMessageProcessor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
@AllArgsConstructor
public class SushiBot extends TelegramLongPollingBot {

    private final List<ReplyKeyboardButtonProcessor> processors;
    private final List<InlineKeyboardButtonProcessor> inlineProcessors;
    private final List<TextMessageProcessor> textMessageProcessors;
    private final List<PhoneNumberProcessor> phoneNumberProcessors;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            processors
                    .stream()
                    .filter(processor -> processor.supports(message.getText()))
                    .findFirst()
                    .ifPresentOrElse(
                            processor -> processor.processMessage(this, message),
                            () -> textMessageProcessors
                                    .stream()
                                    .filter(processor -> processor.supports(message))
                                    .findFirst()
                                    .ifPresent(processor -> processor.processMessage(this, message)));
        } else if (update.hasCallbackQuery()) {
            CallbackQuery query = update.getCallbackQuery();
            inlineProcessors
                    .stream()
                    .filter(processor -> processor.supports(query.getData()))
                    .findFirst()
                    .ifPresent(processor -> processor.processMessage(this, query));
        } else if (update.hasMessage() && update.getMessage().hasContact()) {
            Message message = update.getMessage();
            phoneNumberProcessors
                    .stream()
                    .filter(processor -> processor.supports(message))
                    .findFirst()
                    .ifPresent(processor -> processor.processMessage(this, message));
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


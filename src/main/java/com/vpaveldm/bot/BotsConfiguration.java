package com.vpaveldm.bot;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BotsConfiguration {
    private final List<LongPollingBot> telegramLongPollingBots;

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        telegramLongPollingBots.forEach(bot -> registerBot(telegramBotsApi, bot));
        return telegramBotsApi;
    }

    @SneakyThrows
    private BotSession registerBot(TelegramBotsApi telegramBotsApi, LongPollingBot bot) {
        log.info("Registering bot for: {}", bot.getClass());
        try {
            return telegramBotsApi.registerBot(bot);
        } catch (TelegramApiRequestException exception) {
            log.error("Error registering bot: {}", bot.getClass(), exception);
            return null;
        }
    }
}

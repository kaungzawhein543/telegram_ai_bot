package com.ai.Boyfriend_chatbot.configurations;

import com.ai.Boyfriend_chatbot.telegrambot.longpulling.MyLongPollingBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class AppConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(MyLongPollingBot myBot) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(myBot);
        return api;
    }
}

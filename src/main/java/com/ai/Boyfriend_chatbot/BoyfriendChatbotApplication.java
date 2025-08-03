package com.ai.Boyfriend_chatbot;

import com.ai.Boyfriend_chatbot.telegrambot.longpulling.MyLongPollingBot;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class BoyfriendChatbotApplication {

	public static void main(String[] args) {
		// load Dot Env
		loadDotEnv();
		SpringApplication.run(BoyfriendChatbotApplication.class, args);
	}

	private static void loadDotEnv() {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("TELEGRAM_BOT_TOKEN", dotenv.get("TELEGRAM_BOT_TOKEN"));
		System.setProperty("TELEGRAM_BOT_USERNAME", dotenv.get("TELEGRAM_BOT_USERNAME"));
		System.setProperty("OPENAI_API_KEY", dotenv.get("OPENAI_API_KEY"));
		System.setProperty("PINE_CONE_API_KEY", dotenv.get("PINE_CONE_API_KEY"));
	}

}

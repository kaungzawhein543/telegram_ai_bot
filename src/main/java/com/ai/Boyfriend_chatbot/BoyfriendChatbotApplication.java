package com.ai.Boyfriend_chatbot;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		System.setProperty("OPENAI_API_KEY", dotenv.get("OPENAI_API_KEY"));
		System.setProperty("PINE_CONE_API_KEY", dotenv.get("PINE_CONE_API_KEY"));
	}

}

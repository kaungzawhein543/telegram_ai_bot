package com.ai.Boyfriend_chatbot.services.telegram;

import com.ai.Boyfriend_chatbot.common.APIConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramService  {

    @Value("${telegram.bot.token}")
    private String bot_token;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendMessage(Long chatId, String text) {
        String url = APIConstants.TELEGRAM_API + bot_token + "/sendMessage";

        Map<String, Object> request = new HashMap<>();
        request.put("chat_id", chatId);
        request.put("text", text);

        restTemplate.postForObject(url,request,String.class);
    }
}

package com.ai.Boyfriend_chatbot.controllers;


import com.ai.Boyfriend_chatbot.common.WebUrl;
import com.ai.Boyfriend_chatbot.services.telegram.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(WebUrl.TELEGRAM_WEBHOOK)
public class TelegramWebhookController {

    private final TelegramService telegramService;

    public TelegramWebhookController(TelegramService telegramService) {
        this.telegramService = telegramService;
    }

    @PostMapping
    private ResponseEntity<?> handleUpdate(@RequestBody Map<String, Object> update) {
        Map<String, Object> message = (Map<String, Object>) update.get("message");
        if(message != null) {
            Long chatId = Long.parseLong(message.get("chat").toString().replaceAll("[^0-9]", ""));
            String text = message.get("text").toString();

                telegramService.sendMessage(chatId,"you said"+ text);
        }
        return ResponseEntity.ok().build();
    }

}

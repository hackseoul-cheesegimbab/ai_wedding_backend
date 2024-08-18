package com.hackseoul.aiwedding.wedding.aichat.controller;

import com.hackseoul.aiwedding.wedding.aichat.model.AIChatResponse;
import com.hackseoul.aiwedding.wedding.aichat.service.AIChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AIChatController {
    private final AIChatService aiChatService;

    @GetMapping("api/v1/ai/generate")
    public ResponseEntity<AIChatResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "결혼식 언제 할까")
            String promptMessage) {
        final AIChatResponse aiResponse = aiChatService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @GetMapping("api/v1/ai/generate/joke/{topic}")
    public ResponseEntity<AIChatResponse> generateJoke(@PathVariable String topic) {
        final AIChatResponse aiResponse = aiChatService.generateJoke(topic);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}

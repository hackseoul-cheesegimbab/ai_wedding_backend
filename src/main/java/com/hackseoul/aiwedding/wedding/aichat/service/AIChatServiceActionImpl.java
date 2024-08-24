package com.hackseoul.aiwedding.wedding.aichat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AIChatServiceActionImpl {
    private final OllamaChatModel ollamaChatModel;

    @Async
    public CompletableFuture<String> aiChatAction(String promptMessage) {
        try {
            String data = ollamaChatModel.call(promptMessage);
            System.out.println("data = " + data);
            return CompletableFuture.completedFuture("0000");
        } catch (Exception e) {
            return CompletableFuture.completedFuture("error");
        }
    }

}

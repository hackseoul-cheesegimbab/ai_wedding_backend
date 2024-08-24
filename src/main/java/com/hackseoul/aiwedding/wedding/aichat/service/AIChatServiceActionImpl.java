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
    public CompletableFuture<String> aiChatAction() {
        try {
            Thread.sleep(2000);  // 2초 동안 대기
//            ollamaChatModel.call(promptMessage);
            return CompletableFuture.completedFuture("0000");
        } catch (InterruptedException e) {
            return CompletableFuture.completedFuture("1000");
        }
    }

}

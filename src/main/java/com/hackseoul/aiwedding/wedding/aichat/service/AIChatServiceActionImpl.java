package com.hackseoul.aiwedding.wedding.aichat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIChatServiceActionImpl {
    private final OllamaChatModel ollamaChatModel;

    @Async
    public CompletableFuture<String> aiChatAction(String promptMessage) {
        try {
            if(!"".equals(promptMessage)) {
                String data = ollamaChatModel.call(promptMessage);
                log.info("data : " + data);
                return CompletableFuture.completedFuture(data);
            } else {
                return CompletableFuture.completedFuture("0000");
            }
        } catch (Exception e) {
            return CompletableFuture.completedFuture("error");
        }
    }

}

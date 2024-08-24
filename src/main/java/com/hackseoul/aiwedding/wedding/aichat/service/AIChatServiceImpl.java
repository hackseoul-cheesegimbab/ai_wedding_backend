package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIChatServiceImpl implements AIChatService {

    private final OllamaChatModel ollamaChatModel;
    private final AIChatServiceActionImpl aiChatServiceActionImpl;

    @Override
    public AIChatResponse generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        return new AIChatResponse().setMessage(llamaMessage);
    }

    @Override
    public void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation) {

    }
}

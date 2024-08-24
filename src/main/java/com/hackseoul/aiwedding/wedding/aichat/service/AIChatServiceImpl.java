package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import com.hackseoul.aiwedding.wedding.aichat.repository.WeddingHallDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIChatServiceImpl implements AIChatService {

    private final OllamaChatModel ollamaChatModel;
    private final AIChatServiceActionImpl aiChatServiceActionImpl;
    private final WeddingHallDataRepository weddingHallDataRepository;

    @Override
    public AIChatResponse.getMessage generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        return new AIChatResponse.getMessage().setMessage(llamaMessage);
    }

    @Override
    public void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation) {
        List<Map> weddingHallList = weddingHallDataRepository.find();

    }
}

package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;

public interface AIChatService {
    AIChatResponse generateMessage(String prompt);

    void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation);

}


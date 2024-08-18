package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.AIChatResponse;

public interface AIChatService {
    AIChatResponse generateMessage(String prompt);
}


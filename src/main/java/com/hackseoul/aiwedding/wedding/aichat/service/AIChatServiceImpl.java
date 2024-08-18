package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.AIChatResponse;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIChatServiceImpl implements AIChatService {

    private final OllamaChatModel ollamaChatModel;

    @Autowired
    public AIChatServiceImpl(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    @Override
    public AIChatResponse generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        return new AIChatResponse().setMessage(llamaMessage);
    }

    @Override
    public AIChatResponse generateJoke(String topic) {
        final String llamaMessage =
                ollamaChatModel.call(String.format("Tell me a joke about %s", topic));
        return new AIChatResponse().setMessage(llamaMessage);
    }
}

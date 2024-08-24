package com.hackseoul.aiwedding.wedding.aichat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingDataEntity;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIChatServiceImpl implements AIChatService {

    private final OllamaChatModel ollamaChatModel;
    private final AIChatServiceActionImpl aiChatServiceActionImpl;

    private final WeddingInfoDataRepository weddingInfoDataRepository;

    @Override
    public AIChatResponse.getMessage generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        return new AIChatResponse.getMessage().setMessage(llamaMessage);
    }

    @Override
    public void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation) {
        List<WeddingDataEntity> weddingHallData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울시", requestAiRecommendation.getRegion(), "1");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonData = objectMapper.writeValueAsString(weddingHallData);
            System.out.println("jsonData = " + jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("objectMapper Convertor error");
            throw new RuntimeException();
        }

        // 웨딩홀
        if(requestAiRecommendation.getHall()) {

        }

        // 스튜디오
        if(requestAiRecommendation.getStudio()) {

        }
        String script = "예산은";
    }
}

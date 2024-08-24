package com.hackseoul.aiwedding.wedding.aichat.service;

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
        log.info(llamaMessage);
        return new AIChatResponse.getMessage().setMessage(llamaMessage);
    }

    @Override
    public void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation) {


        // 웨딩홀
        if(requestAiRecommendation.getHall()) {
            List<WeddingDataEntity> weddingHallData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울특별시", "중구", "1");

            if(weddingHallData.size() > 0) {
                String jsonData = "{[";
                for (int i = 0; i < weddingHallData.size(); i++) {
                    WeddingDataEntity weddingData = weddingHallData.get(i);
                    jsonData += "{";
                    jsonData += "'seq':" + weddingData.getSeq();
                    jsonData += ",'업체명':'" + weddingData.getName() + "'";
                    jsonData += ",'비용':'" + weddingData.getPrice() + "'";
                    jsonData += "}";
                    if(i != weddingHallData.size() -1) {
                        jsonData +=",";
                    }
                }
                jsonData += "]}";

                log.info("jsonData =" + jsonData);

                String promptMessage = String.format("""
                예산은 %s이고
                아래 데이터를 참고해서 웨딩홀 1개 추천해줘,
                추천 할 때는 참고한 데이터의 seq 만 줘
                """, requestAiRecommendation.getBudget() );
                promptMessage += jsonData;
                String llamaMessage = ollamaChatModel.call(promptMessage);
                log.error("llamaMessage : " + llamaMessage);
            }
        }

        // 스튜디오
        if(requestAiRecommendation.getStudio()) {

        }
        String script = "예산은";
    }
}

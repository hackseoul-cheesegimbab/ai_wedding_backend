package com.hackseoul.aiwedding.wedding.aichat.service;

import com.hackseoul.aiwedding.wedding.aichat.model.entity.AiResultEntity;
import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingDataEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import com.hackseoul.aiwedding.wedding.mypage.repository.AiResultRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoDataRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class AIChatServiceImpl implements AIChatService {

    private final OllamaChatModel ollamaChatModel;
    private final AIChatServiceActionImpl aiChatServiceActionImpl;

    private final WeddingInfoDataRepository weddingInfoDataRepository;
    private final WeddingInfoRepository weddingInfoRepository;
    private final AiResultRepository aiResultRepository;


    @Override
    public AIChatResponse.getMessage generateMessage(String promptMessage) {
        final String llamaMessage = ollamaChatModel.call(promptMessage);
        log.info(llamaMessage);
        return new AIChatResponse.getMessage().setMessage(llamaMessage);
    }

    @Override
    public void recommendationAction(AIChatRequest.requestAiRecommendation requestAiRecommendation) {
        WeddingInfoEntity weddingInfo = new WeddingInfoEntity(requestAiRecommendation);
        WeddingInfoEntity weddingINfoInsert = weddingInfoRepository.save(weddingInfo);

        String script1 = "";
        // 웨딩홀
        List<WeddingDataEntity> weddingHallData = null;
        if(requestAiRecommendation.getHall()) {
            weddingHallData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울특별시", requestAiRecommendation.getRegion(), "1",
                    (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100) - 10000000, (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100));
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

                script1 = String.format("""
                예산은 %s이고, 예산 안으로, 아래 json 데이터(웨딩홀 데이터)를 참고해서,
                최적의 웨딩홀 1개만 추천해줘(seq만 json에 담아서 줘)
                """, Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100));
                script1 += jsonData;
                log.info(script1);
            }
        }

        String script2 = "";
        List<WeddingDataEntity> weddingStudioData = null;
        // 스튜디오
        if(requestAiRecommendation.getStudio()) {
            weddingStudioData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울특별시", requestAiRecommendation.getRegion(), "2",
                    (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100) - 10000000, (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100));
            if(weddingStudioData.size() > 0) {
                String jsonData = "{[";
                for (int i = 0; i < weddingStudioData.size(); i++) {
                    WeddingDataEntity weddingData = weddingHallData.get(i);
                    jsonData += "{";
                    jsonData += "'seq':" + weddingData.getSeq();
                    jsonData += ",'업체명':'" + weddingData.getName() + "'";
                    jsonData += ",'비용':'" + weddingData.getPrice() + "'";
                    jsonData += "}";
                    if(i != weddingStudioData.size() -1) {
                        jsonData +=",";
                    }
                }
                jsonData += "]}";

                log.info("jsonData =" + jsonData);

                script1 = String.format("""
                예산은 %s이고, 예산 안으로, 아래 json 데이터(스튜디오 데이터)를 참고해서,
                최적의 스튜디오 1개만 추천해줘(seq만 json에 담아서 줘)
                """, requestAiRecommendation.getBudget() );
                script1 += jsonData;
                log.info(script1);
            }
        }

        String script3 = "";
        List<WeddingDataEntity> weddingDressData = null;
        // 스튜디오
        if(requestAiRecommendation.getDress()) {
            weddingDressData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울특별시", requestAiRecommendation.getRegion(), "3",
                    (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100) - 10000000, (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100));
            if(weddingDressData.size() > 0) {
                String jsonData = "{[";
                for (int i = 0; i < weddingDressData.size(); i++) {
                    WeddingDataEntity weddingData = weddingDressData.get(i);
                    jsonData += "{";
                    jsonData += "'seq':" + weddingData.getSeq();
                    jsonData += ",'업체명':'" + weddingData.getName() + "'";
                    jsonData += ",'비용':'" + weddingData.getPrice() + "'";
                    jsonData += "}";
                    if(i != weddingDressData.size() -1) {
                        jsonData +=",";
                    }
                }
                jsonData += "]}";

                log.info("jsonData =" + jsonData);

                script1 = String.format("""
                예산은 %s이고, 예산 안으로, 아래 json 데이터(드레스 구매 업체 데이터)를 참고해서,
                최적의 드레스 구매 업체 1개만 추천해줘(seq만 json에 담아서 줘)
                """, requestAiRecommendation.getBudget() );
                script1 += jsonData;
                log.info(script1);
            }
        }

        String script4 = "";
        List<WeddingDataEntity> weddingMakeUpData = null;
        // 메이크업
        if(requestAiRecommendation.getMake_up()) {
            weddingMakeUpData = weddingInfoDataRepository.findAllByCityAndDistrictAndWeddingFlag("서울특별시", requestAiRecommendation.getRegion(), "4",
                    (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100) - 10000000, (long) Math.floor(requestAiRecommendation.getBudget() * requestAiRecommendation.getHall_per() / 100));
            if(weddingMakeUpData.size() > 0) {
                String jsonData = "{[";
                for (int i = 0; i < weddingMakeUpData.size(); i++) {
                    WeddingDataEntity weddingData = weddingMakeUpData.get(i);
                    jsonData += "{";
                    jsonData += "'seq':" + weddingData.getSeq();
                    jsonData += ",'업체명':'" + weddingData.getName() + "'";
                    jsonData += ",'비용':'" + weddingData.getPrice() + "'";
                    jsonData += "}";
                    if(i != weddingMakeUpData.size() -1) {
                        jsonData +=",";
                    }
                }
                jsonData += "]}";

                log.info("jsonData =" + jsonData);

                script1 = String.format("""
                예산은 %s이고, 예산 안으로, 아래 json 데이터(메이크업 업체 데이터)를 참고해서,
                최적의 메이크업 업체 1개만 추천해줘(seq만 json에 담아서 줘)
                """, requestAiRecommendation.getBudget() );
                script1 += jsonData;
                log.info(script1);
            }
        }

        // 비동기 메서드 호출
        // 멍청한 ai ...
        CompletableFuture<String> future1 = aiChatServiceActionImpl.aiChatAction(script1);
        CompletableFuture<String> future2 = aiChatServiceActionImpl.aiChatAction(script2);
        CompletableFuture<String> future3 = aiChatServiceActionImpl.aiChatAction(script3);
        CompletableFuture<String> future4 = aiChatServiceActionImpl.aiChatAction(script4);


        AiResultEntity aiResultEntity = new AiResultEntity();
        // 비동기 작업 결과를 처리
        try {
            aiResultEntity.setSeq(weddingINfoInsert.getSeq());
            String result1 = future1.get();
            if(!"0000".equals(result1) && weddingHallData.size() >0) {
                for (WeddingDataEntity weddingHallDatum : weddingHallData) {
                    if(result1.contains(weddingHallDatum.getName())) {
                        aiResultEntity.setWeddingKey(weddingHallDatum.getSeq());
                    }
                }
            }
            String result2 = future2.get();
            if(!"0000".equals(result2) && weddingStudioData.size() >0) {
                for (WeddingDataEntity weddingStudioDatum : weddingStudioData) {
                    if(result1.contains(weddingStudioDatum.getName())) {
                        aiResultEntity.setStudioKey(weddingStudioDatum.getSeq());
                    }
                }
            }

            String result3 = future3.get();
            if(!"0000".equals(result3) && weddingDressData.size() >0) {
                for (WeddingDataEntity weddingDressDatum : weddingDressData) {
                    if(result1.contains(weddingDressDatum.getName())) {
                        aiResultEntity.setDressKey(weddingDressDatum.getSeq());
                    }
                }
            }

            String result4 = future4.get();
            if(!"0000".equals(result4) && weddingMakeUpData.size() >0) {
                for (WeddingDataEntity weddingMakeUpDatum : weddingMakeUpData) {
                    if(result1.contains(weddingMakeUpDatum.getName())) {
                        aiResultEntity.setMakeUpKey(weddingMakeUpDatum.getSeq());
                    }
                }
            }
            aiResultEntity.setRecordtime(LocalDateTime.now());
            aiResultRepository.save(aiResultEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

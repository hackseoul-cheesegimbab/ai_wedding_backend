package com.hackseoul.aiwedding.wedding.aichat.controller;

import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import com.hackseoul.aiwedding.wedding.aichat.service.AIChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "AI에 질의", description = "AI에 질의하는 API 입니다.")
public class AIChatController {
    private final AIChatService aiChatService;

    @GetMapping("api/v1/ai-generate")
    @Operation(summary = "AI 메시지 생성", description = "주어진 프롬프트 메시지를 기반으로 AI가 응답을 생성합니다.")
    public ResponseEntity<AIChatResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "결혼식 언제 할까")
            String promptMessage) {
        log.info("AI질문들어옴!!!!");
        final AIChatResponse aiResponse = aiChatService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }

    @PostMapping("api/v1/ai-recommendation")
    @ResponseBody
    @Operation(summary = "AI 추천 기능", description = "화면에서 클라이언트가 선택한 데이터를 넘겨서 ai 추천 데이터를 생성합니다.")
    public ResponseEntity<String> recommendation() {
        log.info("추천 데이터 요청");

        return ResponseEntity.status(HttpStatus.OK).body("0000");
    }
}

package com.hackseoul.aiwedding.wedding.aichat.controller;

import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import com.hackseoul.aiwedding.wedding.aichat.service.AIChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "알림 API", description = "컨트롤러에 대한 설명입니다.")
public class AIChatController {
    private final AIChatService aiChatService;

    @GetMapping("api/v1/ai/generate")
    @Operation(summary = "AI 메시지 생성", description = "주어진 프롬프트 메시지를 기반으로 AI가 응답을 생성합니다.")
    @Parameter(name = "AI에게 전달할 메시지", description = "메시지를 입력하세요.")
    public ResponseEntity<AIChatResponse> generate(
            @RequestParam(value = "promptMessage", defaultValue = "결혼식 언제 할까")
            String promptMessage) {
        final AIChatResponse aiResponse = aiChatService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}

package com.hackseoul.aiwedding.wedding.aichat.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

public class AIChatRequest {
    @Data
    @Accessors(chain = true)
    public static class requestAiRecommendation {
        @NotNull(message = "/ai-recommendation 에서 membser_seq 확인 필요")
        private Long member_seq;
        @NotBlank(message = "/ai-recommendation 에서 region 확인 필요")
        private String region;
        @NotNull(message = "/ai-recommendation 에서 budget 확인 필요")
        private Long budget;
        private Boolean hall;
        private Boolean studio;
        private Boolean dress;
        private Boolean make_up;
        private Boolean gift;
        private Boolean dowry;
        private Boolean parent_make_up;
        private Boolean parent_dress;
    }
}

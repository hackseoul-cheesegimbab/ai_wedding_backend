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
        private Double hall_per;
        private Boolean studio;
        private Double studio_per;
        private Boolean dress;
        private Double dress_per;
        private Boolean make_up;
        private Double make_up_per;
        private Boolean gift;
        private Double gift_per;
        private Boolean dowry;
        private Double dowry_per;
        private Boolean parent_make_up;
        private Double parent_make_up_per;
        private Boolean parent_dress;
        private Double parent_dress_per;
    }
}

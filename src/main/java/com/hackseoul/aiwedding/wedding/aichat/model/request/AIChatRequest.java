package com.hackseoul.aiwedding.wedding.aichat.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

public class AIChatRequest {
    @Data
    @Accessors(chain = true)
    public static class requestAiRecommendation {
        @NotNull(message = "")
        private Long member_seq;
        private String region;
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

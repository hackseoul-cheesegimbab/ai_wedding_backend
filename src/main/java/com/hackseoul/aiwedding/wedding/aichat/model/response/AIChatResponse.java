package com.hackseoul.aiwedding.wedding.aichat.model.response;

import lombok.Data;
import lombok.experimental.Accessors;


public class AIChatResponse {

    @Data
    @Accessors(chain = true)
    public static class getMessage {
        private String message;
    }

    @Data
    @Accessors(chain = true)
    public static class getWeddingHallData {
        private String enterprise_name;
        private String name;
        private Long min_cost;
        private Long max_cost;
    }
}

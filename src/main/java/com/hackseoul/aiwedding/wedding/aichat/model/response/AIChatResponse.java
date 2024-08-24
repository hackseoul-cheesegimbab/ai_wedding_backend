package com.hackseoul.aiwedding.wedding.aichat.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AIChatResponse {
    private String message;
}

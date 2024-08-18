package com.hackseoul.aiwedding.wedding.aichat.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AIChatResponse {
    private String message;
}

package com.hackseoul.aiwedding.wedding.mypage.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;


public class LoginRequest {

    @Data
    @Accessors(chain = true)
    public static class loginRequest {
        @NotBlank(message = "blank memeber_id")
        private String member_id;
        @NotBlank(message = "blank member_pw")
        private String member_pw;
    }
}

package com.hackseoul.aiwedding.wedding.mypage.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;


public class LoginRequest {

    @Data
    @Accessors(chain = true)
    public static class loginRequest {
        @NotBlank(message = "/member-login 에서 memeber_id 확인필요")
        private String member_id;
        @NotBlank(message = "/member-login 에서 member_pw 확인필요")
        private String member_pw;
    }
}

package com.hackseoul.aiwedding.wedding.mypage.model.response;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;


public class LoginResponse {

    @Data
    @Accessors(chain = true)
    public static class loginResponse {
        // 0000 > 성공
        // 1000 > 비밀번호 틀림
        @NotBlank
        private String code;
        @NotBlank
        private Long member_seq;
    }
}

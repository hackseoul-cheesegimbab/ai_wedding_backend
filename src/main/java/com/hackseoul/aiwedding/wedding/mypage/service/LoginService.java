package com.hackseoul.aiwedding.wedding.mypage.service;

import com.hackseoul.aiwedding.wedding.mypage.model.request.LoginRequest;
import com.hackseoul.aiwedding.wedding.mypage.model.response.LoginResponse;

public interface LoginService {
    LoginResponse.loginResponse loginAction(LoginRequest.loginRequest loginRequest);
}

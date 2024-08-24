package com.hackseoul.aiwedding.wedding.mypage.controller;


import com.hackseoul.aiwedding.wedding.mypage.model.request.LoginRequest;
import com.hackseoul.aiwedding.wedding.mypage.model.response.LoginResponse;
import com.hackseoul.aiwedding.wedding.mypage.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "login 기능", description = "로그인 및 로그아웃 기능을 제공하는 API입니다.")
@RequestMapping("/api/v1")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/member-login")
    @ResponseBody
    @Operation(summary = "member login", description = "member login 및 회원 가입")
    public ResponseEntity<LoginResponse.loginResponse> loginAction(@Valid @RequestBody LoginRequest.loginRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.loginAction(request));
    }
}

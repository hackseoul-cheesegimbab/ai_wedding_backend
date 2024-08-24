package com.hackseoul.aiwedding.wedding.mypage.controller;

import com.hackseoul.aiwedding.wedding.mypage.model.response.MypageResponse;
import com.hackseoul.aiwedding.wedding.mypage.service.MypageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "마이페이지", description = "마이페이지에서 사용하는 API 입니다.")
public class MypageController {

     private final MypageService mypageService;

    @GetMapping("api/v1/gu-info")
    @Operation(summary = "서울 구 정보 얻기", description = "서울 구 정보를 가지고 오는 기능입니다.")
    public ResponseEntity<MypageResponse.infoResponse> getGuInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(mypageService.getGuInfo());
    }

}

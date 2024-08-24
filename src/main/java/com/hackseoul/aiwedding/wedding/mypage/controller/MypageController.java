package com.hackseoul.aiwedding.wedding.mypage.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "마이페이지", description = "마이페이지에서 사용하는 API 입니다.")
public class MypageController {

    // private final MypageServiceInterface mypageServiceInterface;

    @PostMapping("api/v1/info")




    public void createMypage() {

    }

    public void readMypage() {

    }

    public void updateMypage() {

    }

    public void deleteMypage() {

    }


}

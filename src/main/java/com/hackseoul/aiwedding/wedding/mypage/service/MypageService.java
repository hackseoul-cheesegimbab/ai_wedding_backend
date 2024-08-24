package com.hackseoul.aiwedding.wedding.mypage.service;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.response.MypageResponse;

import java.util.List;

public interface MypageService {

    MypageResponse.infoResponse getGuInfo();
    List<WeddingInfoEntity> getLists();
}

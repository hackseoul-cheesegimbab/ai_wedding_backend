package com.hackseoul.aiwedding.wedding.mypage.service;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.SeoulGuEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.response.MypageResponse;
import com.hackseoul.aiwedding.wedding.mypage.repository.SeoulGuRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final SeoulGuRepository seoulGuRepository;
    private WeddingInfoRepository weddingInfoRepository;

    @Override
    public MypageResponse.infoResponse getGuInfo() {
        List<SeoulGuEntity> list = seoulGuRepository.findAll();
        List<String> resultData = new ArrayList<>();
        for (SeoulGuEntity seoulGuEntity : list) {
            resultData.add(seoulGuEntity.getDistrictName());
        }
        MypageResponse.infoResponse result  = new MypageResponse.infoResponse();
        result.setDistrict_list(resultData);
        return result;
    }

    @Override
    public List<WeddingInfoEntity> getLists() {
        return List.of();
    }
}

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
    private final WeddingInfoRepository weddingInfoRepository;

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
    public MypageResponse.weddingListResponse weddingList(Long memberSeq) {
        MypageResponse.weddingListResponse weddingListResponse = new MypageResponse.weddingListResponse();
        List<WeddingInfoEntity> list = weddingInfoRepository.findByMemberSeqOrderBySeqDesc(memberSeq);
        List<MypageResponse.weddingListDetail> resultList = new ArrayList<>();
        for (WeddingInfoEntity weddingInfo : list) {
            MypageResponse.weddingListDetail weddingListDetail = new MypageResponse.weddingListDetail();
            weddingListDetail.setTitle("서울특별시 "+weddingInfo.getRegion());
            weddingListDetail.setId(weddingInfo.getSeq());
            String subTitle = "조회 항목 : ";
            if(weddingInfo.getHall()) {
                subTitle += "웨딩홀, ";
            }
            if(weddingInfo.getStudio()) {
                subTitle += "스튜디오, ";
            }
            if(weddingInfo.getDress()) {
                subTitle += "드레스, ";
            }
            if(weddingInfo.getMakeUp()) {
                subTitle += "메이크업, ";
            }
            if(weddingInfo.getGift()) {
                subTitle += "예물, ";
            }
            if(weddingInfo.getDowry()) {
                subTitle += "혼수, ";
            }
            if(weddingInfo.getParentMakeUp()) {
                subTitle += "혼주 메이크업, ";
            }
            if(weddingInfo.getParentDress()) {
                subTitle += "혼주 드레스, ";
            }
            weddingListDetail.setSubTitle(subTitle.substring(0, subTitle.length()-2));
            resultList.add(weddingListDetail);
        }

        weddingListResponse.setWeddingListList(resultList);
        return weddingListResponse;
    }

}

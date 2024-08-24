package com.hackseoul.aiwedding.wedding.mypage.service;

import com.hackseoul.aiwedding.wedding.aichat.model.entity.AiResultEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.SeoulGuEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingDataEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.response.MypageResponse;
import com.hackseoul.aiwedding.wedding.mypage.repository.AiResultRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.SeoulGuRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoDataRepository;
import com.hackseoul.aiwedding.wedding.mypage.repository.WeddingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

    private final SeoulGuRepository seoulGuRepository;
    private final WeddingInfoRepository weddingInfoRepository;
    private final WeddingInfoDataRepository weddingInfoDataRepository;
    private final AiResultRepository aiResultRepository;

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

    @Override
    public MypageResponse.weddingDetailResponse weddingDetail(Long seq) {
        MypageResponse.weddingDetailResponse weddingDetailResponse = new MypageResponse.weddingDetailResponse();
        Optional<AiResultEntity> basicAiResultEntity = aiResultRepository.findByWeddingInfoSeqAndFlag(seq, 1);
        if(basicAiResultEntity.isPresent()) {
            weddingDetailResponse.setBasic(this.settingWeddingDetailData(basicAiResultEntity.get()));
        } else {
            weddingDetailResponse.setBasic(new MypageResponse.weddingDetailData());
        }
        Optional<AiResultEntity> premiumAiResultEntity = aiResultRepository.findByWeddingInfoSeqAndFlag(seq, 2);

        if(premiumAiResultEntity.isPresent()) {
            weddingDetailResponse.setPremium(this.settingWeddingDetailData(premiumAiResultEntity.get()));
        } else {
            weddingDetailResponse.setPremium(new MypageResponse.weddingDetailData());
        }
        return weddingDetailResponse;
    }

    public MypageResponse.weddingDetailData settingWeddingDetailData(AiResultEntity aiResultEntity) {
        MypageResponse.weddingDetailData weddingDetailData = new MypageResponse.weddingDetailData();
        Long totalPrice = 0L;
        if(aiResultEntity.getFlag() == 1) {
            weddingDetailData.setTitle("베이직 상품 추천");
        } else {
            weddingDetailData.setTitle("프리미엄 상품 추천");
        }

        if(aiResultEntity.getWeddingKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getWeddingKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setHall(true);
                weddingDetailData.setHall_name(weddingDataEntity.get().getName());
                weddingDetailData.setHall_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setHall_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getStudioKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getStudioKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setStudio(true);
                weddingDetailData.setStudio_name(weddingDataEntity.get().getName());
                weddingDetailData.setStudio_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setStudio_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getDressKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getDressKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setDress(true);
                weddingDetailData.setDress_name(weddingDataEntity.get().getName());
                weddingDetailData.setDress_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setDress_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getGiftKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getGiftKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setGift(true);
                weddingDetailData.setGift_name(weddingDataEntity.get().getName());
                weddingDetailData.setGift_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setGift_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getMakeUpKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getMakeUpKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setMake_up(true);
                weddingDetailData.setMake_up_name(weddingDataEntity.get().getName());
                weddingDetailData.setMake_up_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setMake_up_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getDowryKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getDowryKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setDowry(true);
                weddingDetailData.setDowry_name(weddingDataEntity.get().getName());
                weddingDetailData.setDowry_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setDowry_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getParentDressKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getParentDressKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setParent_dress(true);
                weddingDetailData.setParent_dress_name(weddingDataEntity.get().getName());
                weddingDetailData.setParent_dress_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setParent_dress_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        if(aiResultEntity.getParentMakeUpKey() != null) {
            Optional<WeddingDataEntity> weddingDataEntity = weddingInfoDataRepository.findById(aiResultEntity.getParentMakeUpKey());
            if(weddingDataEntity.isPresent()) {
                weddingDetailData.setParent_make_up(true);
                weddingDetailData.setParent_dress_name(weddingDataEntity.get().getName());
                weddingDetailData.setParent_make_up_address(weddingDataEntity.get().getAddress());
                weddingDetailData.setParent_make_up_price(weddingDataEntity.get().getPrice());
                totalPrice += weddingDataEntity.get().getPrice();
            }
        }

        weddingDetailData.setTotalPrice(totalPrice);
        return weddingDetailData;
    }
}

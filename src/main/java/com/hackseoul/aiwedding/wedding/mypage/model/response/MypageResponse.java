package com.hackseoul.aiwedding.wedding.mypage.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

public class MypageResponse {
    @Data
    @Accessors(chain = true)
    public static class infoResponse {
        private List<String> district_list;
    }

}

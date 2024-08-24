package com.hackseoul.aiwedding.wedding.mypage.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

public class MypageResponse {
    @Data
    @Accessors(chain = true)
    public static class infoResponse {
        private List<String> district_list;
    }

    @Data
    @Accessors(chain = true)
    public static class weddingListResponse {
        private List<weddingListDetail> weddingListList;
    }

    @Data
    @Accessors(chain = true)
    public static class weddingListDetail {
        private String title;
        private Long id;
        private String subTitle;

    }
}

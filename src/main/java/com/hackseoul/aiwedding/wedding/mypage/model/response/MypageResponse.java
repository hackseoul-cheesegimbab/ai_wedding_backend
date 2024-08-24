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

    @Data
    @Accessors(chain = true)
    public static class weddingDetailResponse {
        private weddingDetailData basic;
        private weddingDetailData premium;
    }

    @Data
    @Accessors(chain = true)
    public static  class weddingDetailData {
        private String title;
        private Long totalPrice;
        private Boolean hall;
        private String hall_address;
        private Long hall_price;
        private Boolean studio;
        private String studio_address;
        private Long studio_price;
        private Boolean dress;
        private String dress_address;
        private Long dress_price;
        private Boolean make_up;
        private String make_up_address;
        private Long make_up_price;
        private Boolean gift;
        private String gift_address;
        private Long gift_price;
        private Boolean dowry;
        private String dowry_address;
        private Long dowry_price;
        private Boolean parent_make_up;
        private String parent_make_up_address;
        private Long parent_make_up_price;
        private Boolean parent_dress;
        private String parent_dress_address;
        private Long parent_dress_price;
    }

}

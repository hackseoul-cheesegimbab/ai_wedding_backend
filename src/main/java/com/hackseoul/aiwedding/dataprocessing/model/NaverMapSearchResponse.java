package com.hackseoul.aiwedding.dataprocessing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NaverMapSearchResponse {
    private String title;
    private String link;
    private String category;
    private String address;
    private String roadAddress;
    private String mapx;
    private String mapy;
    private String description;

}

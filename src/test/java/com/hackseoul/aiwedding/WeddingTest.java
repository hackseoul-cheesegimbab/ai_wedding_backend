package com.hackseoul.aiwedding;

import com.hackseoul.aiwedding.dataprocessing.model.NaverMapSearchResponse;
import com.hackseoul.aiwedding.dataprocessing.service.NaverMapSearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;


@SpringBootTest
public class WeddingTest {

    @Autowired
    NaverMapSearchService naverMapSearchService;

    @Test
    void map() throws Exception {

        ResponseEntity<String> searchResult = naverMapSearchService.search("CA웨딩컨벤션_아산");
        System.out.println("ddd.getBody() = " + searchResult.getBody());

        List<NaverMapSearchResponse> filteredItems = naverMapSearchService.filterItems(searchResult.getBody());

        filteredItems.forEach(item -> {
            System.out.println("Title: " + item.getTitle());
            System.out.println("Link: " + item.getLink());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Address: " + item.getAddress());
            System.out.println("Road Address: " + item.getRoadAddress());
            System.out.println("Map X: " + item.getMapx());
            System.out.println("Map Y: " + item.getMapy());
            System.out.println("------------------------");
        });
        String extractCityResult = naverMapSearchService.extractCity("충청남도 아산시 배방읍 희망로 100 KTX역사내 2층");
        System.out.println("[결과의 시와 구]>>>" + extractCityResult);
    }

    @Test
    void fetchEnterpriseData() {
        naverMapSearchService.fetchEnterpriseData();
    }
}
package com.hackseoul.aiwedding;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.dataprocessing.model.NaverMapSearchResponse;
import com.hackseoul.aiwedding.dataprocessing.repository.WeddingDataRepository;
import com.hackseoul.aiwedding.dataprocessing.repository.WeddingHallRepository;
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

    @Autowired
    WeddingDataRepository weddingDataRepository;

    @Autowired
    WeddingHallRepository weddingHallRepository;

    @Test
    void map() throws Exception {

        List<IweddingEnterprise> enterprises = weddingDataRepository.findAllEnterprises();
        enterprises.forEach(e -> {
            System.out.println("Code: " + e.getEnterpriseCode() + ", Name: " + e.getEnterpriseName());
        });

        ResponseEntity<String> searchResult = naverMapSearchService.search("aT포레");
        // System.out.println("ddd.getBody() = " + searchResult.getBody());

        List<NaverMapSearchResponse> filteredItems = naverMapSearchService.filterItems(searchResult.getBody());

        filteredItems.forEach(item -> {
            //System.out.println("Title: " + item.getTitle());
            //System.out.println("Link: " + item.getLink());
            //System.out.println("Category: " + item.getCategory());
            // System.out.println("Address: " + item.getAddress());
            System.out.println("Road Address: " + item.getRoadAddress());
            System.out.println("Map X: " + item.getMapx());
            System.out.println("Map Y: " + item.getMapy());
            System.out.println("------------------------");
        });
        //String extractCityResult = naverMapSearchService.extractCity("충청남도 아산시 배방읍 희망로 100 KTX역사내 2층");
        //System.out.println("[결과의 시와 구]>>>" + extractCityResult);
    }

    @Test
    void fetchEnterpriseData() {
        naverMapSearchService.fetchEnterpriseData();
    }

    @Test
    public void processEnterprisesInBatches() {
        List<IweddingEnterprise> enterprises = weddingDataRepository.findAllEnterprises();

        int batchSize = 5;
        long delayInMillis = 1000;

        for (int i = 0; i < enterprises.size(); i += batchSize) {
            List<IweddingEnterprise> batch = enterprises.subList(i, Math.min(i + batchSize, enterprises.size()));

            batch.forEach(e -> {
                System.out.println("Code: " + e.getEnterpriseCode() + ", Name: " + e.getEnterpriseName());

                ResponseEntity<String> searchResult = naverMapSearchService.search(e.getEnterpriseName());
                System.out.println("ddd.getBody() = " + searchResult.getBody());

                List<NaverMapSearchResponse> filteredItems = null;
                try {
                    filteredItems = naverMapSearchService.filterItems(searchResult.getBody());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                filteredItems.forEach(item -> {
                    String enterpriseCode = e.getEnterpriseCode();
                    System.out.println("[enterpriseCode] " + enterpriseCode);
                    System.out.println("[Road_Address] " + item.getRoadAddress());
                    System.out.println("[Road_Address] " + item.getAddress());
//                    String[] addressParts = item.getRoadAddress().split(" ");
//                    System.out.println("addressParts.length = " + addressParts);
//                    if (addressParts == null) {
//
//                        addressParts = item.getAddress().split(" ");
//                    }
                    String[] addressParts;

                    if (item.getRoadAddress() != null && !item.getRoadAddress().isEmpty()) {
                        addressParts = item.getRoadAddress().split(" ");
                    } else {
                        // Fallback to using the regular address if road address is not available
                        addressParts = item.getAddress().split(" ");
                    }
                    String city = addressParts[0];
                    System.out.println("[city] " + city);

                    String district = addressParts[1];
                    System.out.println("[district] " + district);

                    weddingHallRepository.updateRoadAddressByEnterpriseCode(enterpriseCode, item.getRoadAddress(), city, district);

                    System.out.println("------------------------");
                });
            });

            // Add a delay before processing the next batch
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Restore interrupted state
                throw new RuntimeException("Batch processing was interrupted", ex);
            }
        }
    }
}
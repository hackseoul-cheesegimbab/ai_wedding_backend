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
    public void processEnterprisesInBatches() {
        List<IweddingEnterprise> enterprises = weddingDataRepository.findAllEnterprises();

        int batchSize = 5;
        long delayInMillis = 1000;

        for (int i = 0; i < enterprises.size(); i += batchSize) {
            List<IweddingEnterprise> batch = enterprises.subList(i, Math.min(i + batchSize, enterprises.size()));
            batch.forEach(e -> {
                ResponseEntity<String> searchResult = naverMapSearchService.search(e.getEnterpriseName());
                List<NaverMapSearchResponse> filteredItems = null;
                try {
                    filteredItems = naverMapSearchService.filterItems(searchResult.getBody());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                filteredItems.forEach(item -> {
                    String enterpriseCode = e.getEnterpriseCode();
                    String[] addressParts;
                    String contact = "";

                    if (item.getRoadAddress() != null && !item.getRoadAddress().isEmpty()) {
                        addressParts = item.getRoadAddress().split(" ");
                    } else {
                        addressParts = item.getAddress().split(" ");
                    }
                    String city = addressParts[0];
                    String district = addressParts[1];

                    if (item.getTelephone() != null && !item.getTelephone().isEmpty()) {
                        contact = item.getTelephone();
                    } else {
                        contact = item.getLink();
                    }
                    weddingHallRepository.updateRoadAddressByEnterpriseCode(enterpriseCode, item.getRoadAddress(), city, district, item.getDescription(), contact);
                });
            });

            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt(); // Restore interrupted state
                throw new RuntimeException("Batch processing was interrupted", ex);
            }
        }
    }
}
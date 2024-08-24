package com.hackseoul.aiwedding;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.crawling.persistent.IweddingEnterpriseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ApiTests {

    @Autowired
    private IweddingEnterpriseRepo iweddingEnterpriseRepo;

    @Test
    void test() {
        // JSON 요청 데이터를 정의합니다.
        String requestBody = "{\"type\":\"WDH\",\"corpCd\":\"C2009210009\",\"snsId\":\"0aa2-cd2e-d971d3aa\",\"maxLat\":37.58753108949685,\"maxLng\":127.12191733712994,\"minLat\":37.44284856858377,\"minLng\":126.95588341486541}";

        // WebClient를 사용하여 POST 요청을 보내고 결과를 출력합니다.
        String response = WebClient.builder()
                .baseUrl("https://weddingmap.co.kr:8994")
                .build()
                .post()
                .uri("/WDMAP/main/getCorpList.dt")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        // 응답 결과를 콘솔에 출력합니다.
        System.out.println(response);
    }

    @Test
    void testGet() {
        // WebClient를 사용하여 GET 요청을 보냅니다.
        Map<String, Object> response = WebClient.builder()
                .baseUrl("https://www.ibrandplus.co.kr")
                .build()
                .get()
                .uri("/index.php/php_api/estimate/get_hall_list")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        // 응답 결과를 콘솔에 출력합니다.
        System.out.println(response.get("data").toString());

        // "data" 필드를 List<Map<String, Object>>로 캐스팅합니다.
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) response.get("data");

        // 데이터 리스트를 반복하면서 각 항목을 처리합니다.
        for (Map<String, Object> item : dataList) {
            // 각 필드를 null 체크하고 처리합니다.
            String entCode = item.get("enterprise_code") != null ? item.get("enterprise_code").toString() : null;
            String entName = item.get("enterprise_name") != null ? item.get("enterprise_name").toString() : null;
            String thumbnail = item.get("thumbnail") != null ? item.get("thumbnail").toString() : null;
            String best = item.get("best") != null ? item.get("best").toString() : null;

            // IweddingEnterprise 객체를 빌드합니다.
            IweddingEnterprise iweddingEnterprise = IweddingEnterprise
                    .builder()
                    .enterpriseCode(entCode)
                    .enterpriseName(entName)
                    .thumbnail(thumbnail)
                    .best(best)
                    .build();

            // 객체를 데이터베이스에 저장합니다.
            iweddingEnterpriseRepo.save(iweddingEnterprise);
        }
    }

    @Test
    void selectEnterprise() {
        // 데이터베이스에서 모든 업체 정보를 조회합니다.
        List<IweddingEnterprise> enterprises = iweddingEnterpriseRepo.findAll();

        // 조회 결과를 콘솔에 출력합니다.
        enterprises.forEach(System.out::println);
    }

    @Test
    void getHall() {
//        https://www.ibrandplus.co.kr/index.php/php_api/estimate/get_wedding_hall_list/

        String enterpriseCode = "";
        Map<String, Object> response = WebClient.builder()
                .baseUrl("https://www.ibrandplus.co.kr")
                .build()
                .get()
                .uri("/index.php/php_api/estimate/get_wedding_hall_list/" + enterpriseCode)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}

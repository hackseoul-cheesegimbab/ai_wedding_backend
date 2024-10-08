package com.hackseoul.aiwedding;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.crawling.entity.IweddingWeddingHall;
import com.hackseoul.aiwedding.crawling.persistent.IweddingEnterpriseRepo;
import com.hackseoul.aiwedding.crawling.persistent.IweddingWeddingHallRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ApiTests {

    @Autowired
    private IweddingEnterpriseRepo iweddingEnterpriseRepo;

    @Autowired
    private IweddingWeddingHallRepo iweddingWeddingHallRepo;

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
        // 모든 IweddingEnterprise 엔티티를 가져옵니다.
        List<IweddingEnterprise> enterprises = iweddingEnterpriseRepo.findAll();

        // 각 엔티티에 대해 WebClient를 사용하여 API 호출을 수행합니다.
        List<Map<String, Object>> responses = enterprises.stream()
                .map(item -> {
                    String enterpriseCode = item.getEnterpriseCode();

                    // WebClient를 사용하여 API 호출을 수행합니다.
                    Map<String, Object> response = WebClient.builder()
                            .baseUrl("https://www.ibrandplus.co.kr")
                            .build()
                            .get()
                            .uri("/index.php/php_api/estimate/get_wedding_hall_list/" + enterpriseCode)
                            .retrieve()
                            .bodyToMono(Map.class)
                            .block();

                    return response;
                })
                .collect(Collectors.toList());

        // 응답 결과를 콘솔에 출력합니다.
        responses.forEach(response -> System.out.println(response.toString()));
    }

    @Test
    void getHallSave() {
        // 모든 IweddingEnterprise 엔티티를 가져옵니다.
        List<IweddingEnterprise> enterprises = iweddingEnterpriseRepo.findAll();

        enterprises.forEach(enterprise -> {
            String enterpriseCode = enterprise.getEnterpriseCode();

            // WebClient를 사용하여 API 호출을 수행합니다.
            Map<String, Object> response = WebClient.builder()
                    .baseUrl("https://www.ibrandplus.co.kr")
                    .build()
                    .get()
                    .uri("/index.php/php_api/estimate/get_wedding_hall_list/" + enterpriseCode)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            // 데이터 필드가 List<Map<String, Object>> 타입이라 가정
            List<Map<String, Object>> dataList = (List<Map<String, Object>>) response.get("data");

            if (dataList != null) {
                dataList.forEach(item -> {
                    // 각 항목에 enterprise_code를 추가
                    item.put("enterprise_code", enterpriseCode);

                    IweddingWeddingHall result = IweddingWeddingHall
                            .builder()
                            .enterpriseCode(item.get("enterprise_code") != null ? item.get("enterprise_code").toString() : "empty")
                            .thumbnail(item.get("thumbnail") != null ? item.get("thumbnail").toString() : "")
                            .weddinghallCode(item.get("weddinghall_code") != null ? item.get("weddinghall_code").toString() : "")
                            .name(item.get("name") != null ? item.get("name").toString() : "")
                            .local(item.get("local") != null ? item.get("local").toString() : "")
                            .style(item.get("style") != null ? item.get("style").toString() : "")
                            .shape(item.get("shape") != null ? item.get("shape").toString() : "")
                            .time(item.get("time") != null ? item.get("time").toString() : "")
                            .minPerson(item.get("min_person") != null ? parseIntWithComma(item.get("min_person").toString()) : 0)
                            .seatPerson(item.get("seat_person") != null ? parseIntWithComma(item.get("seat_person").toString()) : 0)
                            .maxPerson(item.get("max_person") != null ? parseIntWithComma(item.get("max_person").toString()) : 0)
                            .food(item.get("food") != null ? item.get("food").toString() : "")
                            .minFoodFee(item.get("min_food_fee") != null ? parseDoubleWithComma(item.get("min_food_fee").toString()) : 0.0)
                            .maxFoodFee(item.get("max_food_fee") != null ? parseDoubleWithComma(item.get("max_food_fee").toString()) : 0.0)
                            .flower(item.get("flower") != null ? item.get("flower").toString() : "")
                            .minArtificialFee(item.get("min_artificial_fee") != null ? parseDoubleWithComma(item.get("min_artificial_fee").toString()) : 0.0)
                            .maxArtificialFee(item.get("max_artificial_fee") != null ? parseDoubleWithComma(item.get("max_artificial_fee").toString()) : 0.0)
                            .minRealFee(item.get("min_real_fee") != null ? parseDoubleWithComma(item.get("min_real_fee").toString()) : 0.0)
                            .maxRealFee(item.get("max_real_fee") != null ? parseDoubleWithComma(item.get("max_real_fee").toString()) : 0.0)
                            .minExternalFee(item.get("min_external_fee") != null ? parseDoubleWithComma(item.get("min_external_fee").toString()) : 0.0)
                            .maxExternalFee(item.get("max_external_fee") != null ? parseDoubleWithComma(item.get("max_external_fee").toString()) : 0.0)
                            .useStatus(item.get("use") != null ? item.get("use").toString() : "")
                            .minUseFee(item.get("min_use_fee") != null ? parseDoubleWithComma(item.get("min_use_fee").toString()) : 0.0)
                            .maxUseFee(item.get("max_use_fee") != null ? parseDoubleWithComma(item.get("max_use_fee").toString()) : 0.0)
                            .directing(item.get("directing") != null ? item.get("directing").toString() : "")
                            .minDirectFee(item.get("min_direct_fee") != null ? parseDoubleWithComma(item.get("min_direct_fee").toString()) : 0.0)
                            .maxDirectFee(item.get("max_direct_fee") != null ? parseDoubleWithComma(item.get("max_direct_fee").toString()) : 0.0)
                            .drink(item.get("drink") != null ? item.get("drink").toString() : "")
                            .drinkFee(item.get("drink_fee") != null ? parseDoubleWithComma(item.get("drink_fee").toString()) : 0.0)
                            .build();

                    iweddingWeddingHallRepo.save(result);
                });
            }
        });
    }

    private Double parseDoubleWithComma(String value) {
        // 쉼표를 제거하고 Double으로 변환
        return Double.parseDouble(value.replace(",", ""));
    }

    private Integer parseIntWithComma(String value) {
        // 쉼표를 제거하고 Integer로 변환
        return Integer.parseInt(value.replace(",", ""));
    }

}

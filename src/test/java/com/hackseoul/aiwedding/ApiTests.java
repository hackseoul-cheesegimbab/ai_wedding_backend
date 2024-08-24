package com.hackseoul.aiwedding;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class ApiTests {

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
}

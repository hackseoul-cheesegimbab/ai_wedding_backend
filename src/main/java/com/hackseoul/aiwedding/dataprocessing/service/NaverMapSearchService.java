package com.hackseoul.aiwedding.dataprocessing.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.dataprocessing.model.NaverMapSearchResponse;
import com.hackseoul.aiwedding.dataprocessing.repository.WeddingDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NaverMapSearchService {

    private final WeddingDataRepository weddingDataRepository;

    @Value("${naver.client-id}")
    private String clientId;

    @Value("${naver.client-secret}")
    private String clientSecret;

    public ResponseEntity<String> search(String text) {

        WebClient webClient = WebClient.builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Naver-Client-Id", clientId)
                .defaultHeader("X-Naver-Client-Secret", clientSecret)
                .build();

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .queryParam("query", text)
                .queryParam("display", 5)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        ResponseEntity<String> responseEntity = webClient.get()
                .uri(uri)
                .retrieve()
                .toEntity(String.class)
                .block();

        return responseEntity;
    }

    public List<NaverMapSearchResponse> filterItems(String jsonResponse) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);
        JsonNode itemsNode = rootNode.path("items");

        List<NaverMapSearchResponse> items = objectMapper.convertValue(
                itemsNode, new TypeReference<List<NaverMapSearchResponse>>() {
                });

        return items.stream()
                .filter(item -> item.getCategory().contains("예식장"))
                .collect(Collectors.toList());
    }

    public String extractCity(String fullAddress) {
        // Split the address by spaces
        String[] addressParts = fullAddress.split(" ");

        // Combine the first two parts to get "충청남도 아산시"
        if (addressParts.length >= 2) {
            return addressParts[0] + " " + addressParts[1];
        } else {
            // Handle case where the address is not in the expected format
            return "";
        }
    }

    public void fetchEnterpriseData() {
        List<IweddingEnterprise> enterprises = weddingDataRepository.findAllEnterprises();
        enterprises.forEach(e -> {
            System.out.println("Code: " + e.getEnterpriseCode() + ", Name: " + e.getEnterpriseName());
        });
    }
}

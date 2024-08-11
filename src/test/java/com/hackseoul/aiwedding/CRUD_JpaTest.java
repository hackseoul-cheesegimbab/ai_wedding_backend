package com.hackseoul.aiwedding;

import com.hackseoul.aiwedding.domain.entity.WishInfo;
import com.hackseoul.aiwedding.domain.repo.WishInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CRUD_JpaTest {

    @Autowired
    private WishInfoRepository wishInfoRepository;

    @Test
    void selectAllTest() {
        wishInfoRepository.findAll();
    }

    @Test
    void selectOneTest() {
        wishInfoRepository.findById(1L);
    }

    @Test
    void insertTest() {

        String _content = """
                최저가 결혼식을 원하고 있습니다.
                서울 중심부에 위치한 결혼식장을 찾고 있습니다.
                금액은 500만원 이하로 원합니다.
                """;

        wishInfoRepository.save(
                WishInfo
                .builder()
                .content(_content)
                .type("wedding")
                .build());
    }

    @Test
    void updateTest() {
        wishInfoRepository.save(WishInfo
                .builder()
                .id(1L)
                .content("최저가 결혼식을 원하고 있습니다.")
                .type("wedding")
                .build());
    }

    @Test
    void deleteTest() {
        wishInfoRepository.deleteById(1L);
    }
}

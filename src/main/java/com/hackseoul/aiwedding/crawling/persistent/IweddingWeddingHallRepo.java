package com.hackseoul.aiwedding.crawling.persistent;

import com.hackseoul.aiwedding.crawling.entity.IweddingWeddingHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IweddingWeddingHallRepo
        extends JpaRepository<IweddingWeddingHall, Long> {
}

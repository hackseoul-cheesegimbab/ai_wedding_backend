package com.hackseoul.aiwedding.dataprocessing.repository;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingDataRepository extends JpaRepository<IweddingEnterprise, Long> {

    @Query("SELECT data FROM IweddingEnterprise data")
    List<IweddingEnterprise> findAllEnterprises();
}

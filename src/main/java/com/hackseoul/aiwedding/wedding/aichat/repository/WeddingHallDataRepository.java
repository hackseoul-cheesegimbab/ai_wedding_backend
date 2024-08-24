package com.hackseoul.aiwedding.wedding.aichat.repository;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface WeddingHallDataRepository extends JpaRepository<IweddingEnterprise, Long> {

    @Query("""
            SELECT
            IE.enterpriseCode,
            IWH.name,
            IWH.minArtificialFee + IWH.minDirectFee + (IWH.minPerson * IWH.minFoodFee)
            + IWH.minRealFee + IWH.minUseFee + IWH.minExternalFee as minCost,
            IWH.maxArtificialFee + IWH.maxDirectFee + IWH.maxExternalFee + (IWH.maxFoodFee * IWH.maxPerson)
            + IWH.maxRealFee + IWH.maxUseFee as maxCost
            FROM IweddingEnterprise IE
            INNER JOIN IweddingWeddingHall IWH
            ON IWH.enterpriseCode = IE.enterpriseCode
            """)
    List<Map> find();
}

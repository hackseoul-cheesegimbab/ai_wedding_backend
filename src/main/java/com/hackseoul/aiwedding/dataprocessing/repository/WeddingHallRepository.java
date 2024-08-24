package com.hackseoul.aiwedding.dataprocessing.repository;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import com.hackseoul.aiwedding.crawling.entity.IweddingWeddingHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface WeddingHallRepository extends JpaRepository<IweddingWeddingHall, Long> {

    @Query("SELECT data FROM IweddingWeddingHall data")
    List<IweddingEnterprise> findAllEnterprises();

    @Modifying
    @Transactional
    @Query("UPDATE IweddingWeddingHall SET roadAddress = :roadAddress, city = :city,district = :district WHERE enterpriseCode = :enterpriseCode")
    void updateRoadAddressByEnterpriseCode(String enterpriseCode, String roadAddress, String city, String district);
}

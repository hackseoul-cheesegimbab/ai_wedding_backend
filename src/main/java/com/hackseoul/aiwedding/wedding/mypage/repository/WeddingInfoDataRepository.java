package com.hackseoul.aiwedding.wedding.mypage.repository;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeddingInfoDataRepository extends JpaRepository<WeddingDataEntity, Long> {

    @Query("""
        SELECT w FROM WeddingDataEntity w where w.city = :city and w.district = :region and w.weddingFlag = :wedding_flag and :start_price <= w.price  and w.price <= :last_price
        """)
    List<WeddingDataEntity> findAllByCityAndDistrictAndWeddingFlag(String city, String region, String wedding_flag, Long start_price, Long last_price);
}

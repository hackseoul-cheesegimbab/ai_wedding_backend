package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.WishInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishInfoRepository extends JpaRepository<WishInfo, Long> {
}

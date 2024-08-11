package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.WeddingMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingMapRepository extends JpaRepository<WeddingMap, Long> {

}

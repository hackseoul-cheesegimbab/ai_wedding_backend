package com.hackseoul.aiwedding.wedding.mypage.repository;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingInfoRepository extends JpaRepository<WeddingInfoEntity, Long> {
    List<WeddingInfoEntity> findByMemberSeqOrderBySeqDesc(Long memberSeq);
}




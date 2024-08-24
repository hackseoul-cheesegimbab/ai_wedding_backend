package com.hackseoul.aiwedding.wedding.mypage.repository;

import com.hackseoul.aiwedding.wedding.aichat.model.entity.AiResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AiResultRepository extends JpaRepository<AiResultEntity, Long> {

    Optional<AiResultEntity> findByWeddingInfoSeqAndFlag(long weddingInfoSeq, int flag);
}

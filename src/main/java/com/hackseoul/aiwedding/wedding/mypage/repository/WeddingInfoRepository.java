package com.hackseoul.aiwedding.wedding.mypage.repository;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.WeddingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingInfoRepository extends JpaRepository<WeddingInfoEntity, Long> {
    @Query("SELECT w FROM WeddingInfoEntity w WHERE w.memberSeq = :memberSeq AND " +
            "w.hall = true AND w.studio = true AND w.dress = true AND w.makeUp = true AND " +
            "w.gitf = true AND w.dowry = true AND w.parentMakeUp = true AND w.parentDress = true")
    List<WeddingInfoEntity> getLists(Long memberSeq);
}




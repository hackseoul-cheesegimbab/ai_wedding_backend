package com.hackseoul.aiwedding.wedding.mypage.repository;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<MemberEntity, Long> {
    long countByMemberId(String memberId);

    Optional<MemberEntity> findByMemberIdAndMemberPw(String memberId, String memberPw);


}

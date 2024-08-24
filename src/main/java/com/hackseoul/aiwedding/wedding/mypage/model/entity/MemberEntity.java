package com.hackseoul.aiwedding.wedding.mypage.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("회원정보")
public class MemberEntity {

    @Id
    @Column(name = "member_seq", nullable = false)
    @Comment("회원번호")
    private Long memberSeq;

    @Column(name = "member_id", nullable = false, length = 50)
    @Comment("아이디")
    private String memberId;

    @Column(name = "member_pw", nullable = false, length = 100)
    @Comment("비밀번호")
    private String memberPw;

    @Column(name = "recordtime", nullable = false)
    @Comment("저장시간")
    private LocalDateTime recordtime;
}
package com.hackseoul.aiwedding.wedding.mypage.model.entity;

import com.hackseoul.aiwedding.wedding.mypage.model.request.LoginRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("회원정보")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public MemberEntity(LoginRequest.loginRequest loginRequest) {
        this.memberId = loginRequest.getMember_id();
        this.memberPw = loginRequest.getMember_pw();
        this.recordtime = LocalDateTime.now();
    }
}

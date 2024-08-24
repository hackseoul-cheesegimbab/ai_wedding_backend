package com.hackseoul.aiwedding.wedding.aichat.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_result")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("AI 추천 결과")
public class AiResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    @Comment("기본키")
    private Long seq;

    @Column(name = "wedding_info_seq", nullable = false)
    @Comment("웨딩 기본키")
    private Long weddingInfoSeq;

    @Column(name = "flag", nullable = false)
    @Comment("플래그")
    private Integer flag;

    @Column(name = "wedding_key")
    @Comment("웨딩홀 키")
    private Long weddingKey;

    @Column(name = "studio_key")
    @Comment("스튜디오 키")
    private Long studioKey;

    @Column(name = "dress_key")
    @Comment("드레스 키")
    private Long dressKey;

    @Column(name = "make_up_key")
    @Comment("메이크업 키")
    private Long makeUpKey;

    @Column(name = "gift_key")
    @Comment("예물 키")
    private Long giftKey;

    @Column(name = "dowry_key")
    @Comment("혼수 키")
    private Long dowryKey;

    @Column(name = "parent_make_up_key")
    @Comment("혼주 메이크업 키")
    private Long parentMakeUpKey;

    @Column(name = "parent_dress_key")
    @Comment("혼주 드레스 키")
    private Long parentDressKey;

    @Column(name = "recordtime", nullable = false)
    @Comment("저장시간")
    private LocalDateTime recordtime;
}

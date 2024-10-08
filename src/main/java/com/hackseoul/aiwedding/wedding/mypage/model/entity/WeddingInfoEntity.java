package com.hackseoul.aiwedding.wedding.mypage.model.entity;

import com.hackseoul.aiwedding.wedding.aichat.model.request.AIChatRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "wedding_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("회원 결혼 정보")
public class WeddingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", nullable = false)
    @Comment("결혼 정보 번호")
    private Long seq;


    @Column(name = "member_seq", nullable = false)
    @Comment("회원번호")
    private Long memberSeq;

    @Column(name = "region", nullable = false, length = 10)
    @Comment("지역")
    private String region;

    @Column(name = "budget", nullable = false)
    @Comment("결혼식의 예산")
    private Long budget;

    @Column(name = "hall")
    @Comment("웨딩홀 선택 여부")
    private Boolean hall;

    @Column(name = "studio")
    @Comment("스튜디오 선택 여부")
    private Boolean studio;

    @Column(name = "dress")
    @Comment("드레스 선택 여부")
    private Boolean dress;

    @Column(name = "make_up")
    @Comment("메이크업 선택 여부")
    private Boolean makeUp;

    @Column(name = "gift")
    @Comment("예물 선택 여부")
    private Boolean gift;

    @Column(name = "dowry")
    @Comment("혼수 선택여부")
    private Boolean dowry;

    @Column(name = "parent_make_up")
    @Comment("혼주메이크업 선택 여부")
    private Boolean parentMakeUp;

    @Column(name = "parent_dress")
    @Comment("혼주 드레스")
    private Boolean parentDress;

    public WeddingInfoEntity(AIChatRequest.requestAiRecommendation requestAiRecommendation) {
        this.memberSeq = requestAiRecommendation.getMember_seq();
        this.region = requestAiRecommendation.getRegion();
        this.budget = requestAiRecommendation.getBudget();
        this.hall = requestAiRecommendation.getHall();
        this.studio = requestAiRecommendation.getStudio();
        this.dress = requestAiRecommendation.getDress();
        this.makeUp = requestAiRecommendation.getMake_up();
        this.gift = requestAiRecommendation.getGift();
        this.dowry = requestAiRecommendation.getDowry();
        this.parentMakeUp = requestAiRecommendation.getParent_make_up();
        this.parentDress = requestAiRecommendation.getParent_dress();
    }
}

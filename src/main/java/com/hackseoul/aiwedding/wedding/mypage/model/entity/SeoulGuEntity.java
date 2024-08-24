package com.hackseoul.aiwedding.wedding.mypage.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "seoul_gu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("서울 구 정보")
public class SeoulGuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id", nullable = false)
    @Comment("구 번호")
    private Long districtId;

    @Column(name = "district_name", nullable = false)
    @Comment("구 이름")
    private String districtName;

    @Column(name = "created_at", nullable = false)
    @Comment("저장시간")
    private LocalDateTime createdAt;
}

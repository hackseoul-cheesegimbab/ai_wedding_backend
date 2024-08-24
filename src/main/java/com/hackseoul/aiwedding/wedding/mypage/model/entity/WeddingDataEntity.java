package com.hackseoul.aiwedding.wedding.mypage.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "wedding_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("업체 데이터")
public class WeddingDataEntity {

    @Id
    @Column(name = "seq", nullable = false)
    @Comment("기본키")
    private Long seq;

    @Column(name = "wedding_flag", nullable = false, length = 2)
    @Comment("업체의 플래그")
    private String weddingFlag;

    @Column(name = "name", length = 50)
    @Comment("업체명")
    private String name;

    @Column(name = "city", length = 10)
    @Comment("시명칭")
    private String city;

    @Column(name = "district", length = 10)
    @Comment("구명칭")
    private String district;

    @Column(name = "address", length = 200)
    @Comment("주소")
    private String address;

    @Column(name = "phone", length = 255)
    @Comment("전화번호")
    private String phone;

    @Column(name = "price", length = 50)
    @Comment("비용")
    private String price;

    @Column(name = "description", columnDefinition = "TEXT")
    @Comment("설명")
    private String description;
}

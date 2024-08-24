package com.hackseoul.aiwedding.crawling.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class IweddingEnterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String enterpriseCode;

    @Column
    private String enterpriseName;

    @Column
    private String thumbnail;

    @Column
    private String best;
}

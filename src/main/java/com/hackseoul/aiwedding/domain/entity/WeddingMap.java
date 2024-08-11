package com.hackseoul.aiwedding.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Schema(description = "결혼식 장소")
public class WeddingMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "장소 아이디")
    private Long id;

    @Column
    @CreatedDate
    @Schema(description = "생성일")
    private LocalDateTime createdDate;

    @Column
    @LastModifiedDate
    @Schema(description = "수정일")
    private LocalDateTime lastModifiedDate;
}

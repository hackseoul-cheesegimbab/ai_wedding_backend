package com.hackseoul.aiwedding.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 플랜을 위한 정보
@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Schema(description = "플랜을 위한 정보")
public class WishInfo {

    @Id
    @GeneratedValue
    @Schema(description = "플랜 아이디")
    private Long id;

    @Column
    @Schema(description = "플랜 타입")
    private String type;

    @Column
    @CreatedDate
    @Schema(description = "생성일")
    private LocalDateTime createdDate;

    @Column
    @LastModifiedDate
    @Schema(description = "수정일")
    private LocalDateTime lastModifiedDate;
}

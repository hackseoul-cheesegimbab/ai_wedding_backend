package com.hackseoul.aiwedding.domain;

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
public class Friend {

    @Id
    @GeneratedValue
    @Schema(description = "친구 아이디")
    private Long id;

    @Column
    @Schema(description = "주변 타입" , example = "friend, cousin, coworker")
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

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
public class Me {

    @Id
    @GeneratedValue
    @Schema(description = "나의 아이디")
    private Long id;

    @Column
    @Schema(description = "나의 이름")
    private String name;

    @Column
    @Schema(description = "나의 나이")
    private Integer age;

    @Column
    @Schema(description = "나의 성별")
    private String sex;

    @Column
    @CreatedDate
    @Schema(description = "생성일")
    private LocalDateTime createdDate;

    @Column
    @LastModifiedDate
    @Schema(description = "수정일")
    private LocalDateTime lastModifiedDate;
}

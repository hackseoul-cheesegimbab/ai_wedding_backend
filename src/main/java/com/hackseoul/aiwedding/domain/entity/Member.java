package com.hackseoul.aiwedding.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원 정보")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "회원 아이디")
    private Long id;

    @Column
    @Schema(description = "회원 이름")
    private String password;

    @CreatedDate
    @Schema(description = "생성일")
    private LocalDate createDate;


}

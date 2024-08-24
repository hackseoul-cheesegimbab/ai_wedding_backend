package com.hackseoul.aiwedding.wedding.aichat.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Comment("AI 호출 기록")
public class AiLogEntity {

    @Id
    @Column(name = "request_time", nullable = false)
    @Comment("AI 호출한 시간")
    private LocalDateTime requestTime;

    @Column(name = "request_data", nullable = false, columnDefinition = "TEXT")
    @Comment("요청데이터")
    private String requestData;

    @Column(name = "response_data", nullable = false, columnDefinition = "TEXT")
    @Comment("응답데이터")
    private String responseData;
}

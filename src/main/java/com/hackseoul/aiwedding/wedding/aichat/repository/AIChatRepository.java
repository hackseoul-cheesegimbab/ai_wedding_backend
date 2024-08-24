package com.hackseoul.aiwedding.wedding.aichat.repository;

import com.hackseoul.aiwedding.wedding.aichat.model.response.AIChatResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIChatRepository extends JpaRepository<AIChatResponse, Long> {

}

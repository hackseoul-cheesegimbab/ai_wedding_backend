package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.ResultPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultPlanRepository extends JpaRepository<ResultPlan, Long> {


}

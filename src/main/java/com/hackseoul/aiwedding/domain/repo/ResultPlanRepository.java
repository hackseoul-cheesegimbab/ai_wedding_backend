package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.ResultPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultPlanRepository extends JpaRepository<ResultPlan, Long> {

    List<ResultPlan> findByUserId(Long userId);

    List<ResultPlan> findByFriendId(Long friendId);

    List<ResultPlan> findByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserId(Long userId);

    void deleteByFriendId(Long friendId);

}

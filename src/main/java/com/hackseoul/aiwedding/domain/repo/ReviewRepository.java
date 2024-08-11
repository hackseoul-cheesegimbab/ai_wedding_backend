package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long userId);

    List<Review> findByFriendId(Long friendId);

    List<Review> findByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserId(Long userId);

    void deleteByFriendId(Long friendId);
}

package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.WeddingMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeddingMapRepository extends JpaRepository<WeddingMap, Long> {
    List<WeddingMap> findByUserId(Long userId);

    List<WeddingMap> findByFriendId(Long friendId);

    List<WeddingMap> findByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserId(Long userId);

    void deleteByFriendId(Long friendId);
}

package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.WishInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishInfoRepository extends JpaRepository<WishInfo, Long> {
    List<WishInfo> findByUserId(Long userId);

    List<WishInfo> findByFriendId(Long friendId);

    List<WishInfo> findByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserId(Long userId);

    void deleteByFriendId(Long friendId);
}

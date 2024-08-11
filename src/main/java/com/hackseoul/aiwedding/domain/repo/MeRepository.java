package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.Me;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeRepository extends JpaRepository<Me, Long> {

    List<Me> findByUserId(Long userId);

    List<Me> findByFriendId(Long friendId);

    List<Me> findByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserIdAndFriendId(Long userId, Long friendId);

    void deleteByUserId(Long userId);

    void deleteByFriendId(Long friendId);
}

package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {


}

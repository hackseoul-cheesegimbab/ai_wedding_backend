package com.hackseoul.aiwedding.domain.repo;

import com.hackseoul.aiwedding.domain.entity.Me;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeRepository extends JpaRepository<Me, Long> {

}

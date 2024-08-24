package com.hackseoul.aiwedding.crawling.persistent;

import com.hackseoul.aiwedding.crawling.entity.IweddingEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IweddingEnterpriseRepo
        extends JpaRepository<IweddingEnterprise, Long> {
}

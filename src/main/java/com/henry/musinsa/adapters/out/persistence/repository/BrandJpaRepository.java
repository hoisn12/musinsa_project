package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.entity.BrandJPAEntity;
import com.henry.musinsa.domain.Brand;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<BrandJPAEntity, String> {
    BrandJPAEntity findByIdAndIsDel(String id, Boolean isDel);
}

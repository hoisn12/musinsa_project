package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.entity.BrandJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandJpaRepository extends JpaRepository<BrandJPAEntity, String> {

}

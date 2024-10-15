package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.entity.ProductCategoryJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductCategoryJpaRepository extends JpaRepository<ProductCategoryJPAEntity, String> {
    Optional<ProductCategoryJPAEntity> findByTitle(String title);
}

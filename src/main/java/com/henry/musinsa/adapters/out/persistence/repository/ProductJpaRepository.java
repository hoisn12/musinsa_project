package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.ProductJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductJPAEntity, Long> {

}

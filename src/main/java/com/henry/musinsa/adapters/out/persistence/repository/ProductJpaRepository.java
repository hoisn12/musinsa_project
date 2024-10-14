package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;
import com.henry.musinsa.adapters.out.persistence.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJPAEntity, String>, ProductRepositoryCustom {

}

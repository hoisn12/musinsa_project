package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ProductCategoryQueryUseCase {

    /**
     * 전체 카테고리 조회
     * @return ProductCategory 도메인
     */
    List<ProductCategory> getAllCategory();

    /**
     * id 기준 카테고리 조회
     * @param id 카테고리 id
     * @return ProductCategory 도메인
     */
    ProductCategory getProductCategory(String id);
}

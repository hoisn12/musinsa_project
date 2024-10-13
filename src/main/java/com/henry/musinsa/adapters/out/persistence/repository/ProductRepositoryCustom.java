package com.henry.musinsa.adapters.out.persistence.repository;


import com.henry.musinsa.adapters.out.persistence.ProductJPAEntity;
import com.henry.musinsa.application.dto.CategoryPriceDTO;


import java.util.List;

public interface ProductRepositoryCustom {
    List<CategoryPriceDTO> findLowestPriceProductByCategory();
    List<ProductJPAEntity> findLowestPriceBrandForAllCategories();
    List<ProductJPAEntity> findLowestAndHighestPriceBrandsByCategory();
}

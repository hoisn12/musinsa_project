package com.henry.musinsa.adapters.out.persistence.repository.custom;


import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;
import com.henry.musinsa.application.dto.BrandSumPriceDTO;
import com.henry.musinsa.application.dto.CategoryPriceDTO;


import java.util.List;


public interface ProductRepositoryCustom {
    List<CategoryPriceDTO> findLowestPriceByCategoryAndBrand();
    BrandSumPriceDTO findBrandWithLowestTotalPrice();
    List<ProductJPAEntity> findLowestPriceForAllCategoriesByBrand(String brandId);
    List<ProductJPAEntity> findMinPriceProductsByCategoryName(String categoryName);
    List<ProductJPAEntity> findMaxPriceProductsByCategoryName(String categoryName);
}

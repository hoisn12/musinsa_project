package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.record.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductQueryUseCase {

    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    CategoryPriceSummaryDTO getLowestPriceByCategoryAndBrandUseCase();
    BrandSumPriceSummaryDTO getLowestPriceForAllCategoriesByBrand();
    List<Product> getLowestAndHighestPriceBrandsByCategory();
}

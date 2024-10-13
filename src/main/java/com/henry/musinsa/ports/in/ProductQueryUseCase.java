package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductQueryUseCase {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    CategoryPriceSummaryDTO getLowestPriceForCategoryUseCase();
    List<Product> getLowestPriceBrandForAllCategories();
    List<Product> getLowestAndHighestPriceBrandsByCategory();
}

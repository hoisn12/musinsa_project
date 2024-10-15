package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.application.dto.ProductLowestAndHighestDTO;
import com.henry.musinsa.application.dto.ProductLowestAndHighestResponseDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductQueryUseCase {

    List<Product> getAllProducts();
    Optional<Product> getProductById(String id);
    CategoryPriceSummaryDTO getLowestPriceByCategoryAndBrandUseCase();
    BrandSumPriceSummaryDTO getLowestPriceForAllCategoriesByBrand();
    ProductLowestAndHighestResponseDTO getLowestAndHighestPriceBrandsByCategory(String categoryName);
}

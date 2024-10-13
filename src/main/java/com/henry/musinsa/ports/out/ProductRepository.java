package com.henry.musinsa.ports.out;

import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    CategoryPriceSummaryDTO findLowestPriceProductByCategory();
}

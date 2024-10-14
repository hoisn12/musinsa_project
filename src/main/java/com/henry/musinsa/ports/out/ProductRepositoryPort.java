package com.henry.musinsa.ports.out;

import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    List<Product> findAll();
    Optional<Product> findById(String id);
    Product save(Product product);
    List<Product> saveAll(List<Product> product);
    CategoryPriceSummaryDTO findLowestPriceByCategoryAndBrand();
}

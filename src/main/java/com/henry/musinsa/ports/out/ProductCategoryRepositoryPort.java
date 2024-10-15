package com.henry.musinsa.ports.out;

import com.henry.musinsa.domain.ProductCategory;
import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepositoryPort {
    List<ProductCategory> findAll();
    Optional<ProductCategory> findById(String id);
    ProductCategory save(ProductCategory product);
    List<ProductCategory> saveAll(List<ProductCategory> product);
    void flush();
}

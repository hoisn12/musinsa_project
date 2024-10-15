package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ProductCategoryQueryUseCase {

    List<ProductCategory> getAllCategory();

    ProductCategory getProductCategory(String id);
}

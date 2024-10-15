package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.ProductCategory;

public interface ProductCategoryQueryUseCase {

    ProductCategory getProductCategory(String id);
}

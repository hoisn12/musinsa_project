package com.henry.musinsa.application;

import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.ports.in.ProductCategoryQueryUseCase;
import com.henry.musinsa.ports.out.ProductCategoryRepositoryPort;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryQueryService implements ProductCategoryQueryUseCase {

    private final ProductCategoryRepositoryPort productCategoryRepository;

    @Override
    public ProductCategory getProductCategory(String id) {
        return productCategoryRepository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_CATEGORY_NOT_FOUND));
    }

}

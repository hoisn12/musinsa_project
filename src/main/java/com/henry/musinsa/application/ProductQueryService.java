package com.henry.musinsa.application;

import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

    private final ProductRepositoryPort productRepository;

    @Override
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryPriceSummaryDTO getLowestPriceByCategoryAndBrandUseCase() {
        return productRepository.findLowestPriceByCategoryAndBrand();
    }

    @Override
    public List<Product> getLowestPriceForAllCategoriesByBrand() {
        return List.of();
    }

    @Override
    public List<Product> getLowestAndHighestPriceBrandsByCategory() {
        return List.of();
    }
}

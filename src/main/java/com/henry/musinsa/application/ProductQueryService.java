package com.henry.musinsa.application;

import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import com.henry.musinsa.ports.out.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

    private final ProductRepository productRepository;

    @Override
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public CategoryPriceSummaryDTO getLowestPriceForCategoryUseCase() {
        return productRepository.findLowestPriceProductByCategory();
    }

    @Override
    public List<Product> getLowestPriceBrandForAllCategories() {
        return List.of();
    }

    @Override
    public List<Product> getLowestAndHighestPriceBrandsByCategory() {
        return List.of();
    }
}

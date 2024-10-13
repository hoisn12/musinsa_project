package com.henry.musinsa.application;

import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductCommandUseCase;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import com.henry.musinsa.ports.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }
}

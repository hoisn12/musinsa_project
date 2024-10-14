package com.henry.musinsa.application;

import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductCommandUseCase;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductRepositoryPort productRepository;

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

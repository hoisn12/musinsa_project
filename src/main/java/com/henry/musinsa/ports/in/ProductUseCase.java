package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductUseCase {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);

}

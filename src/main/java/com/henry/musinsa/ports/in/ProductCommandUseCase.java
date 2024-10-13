package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Product;


public interface ProductCommandUseCase {

    Product createProduct();
    void updateProduct();
    void deleteProduct();

}

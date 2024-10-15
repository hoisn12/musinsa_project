package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.application.dto.ProductUpdateDTO;
import com.henry.musinsa.domain.Product;


public interface ProductCommandUseCase {

    Product createProduct(ProductCreateDTO productCommandDTO);
    Product updateProduct(ProductUpdateDTO productUpdateDTO);
    void deleteProduct(String productId);

}

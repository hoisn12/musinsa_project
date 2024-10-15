package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.record.ProductCreateDTO;
import com.henry.musinsa.application.record.ProductUpdateDTO;
import com.henry.musinsa.domain.Product;


public interface ProductCommandUseCase {

    Product createProduct(ProductCreateDTO productCommandDTO);
    Product updateProduct(ProductUpdateDTO productUpdateDTO);
    void deleteProduct(String productId);

}

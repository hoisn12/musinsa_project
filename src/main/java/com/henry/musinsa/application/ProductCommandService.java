package com.henry.musinsa.application;

import com.henry.musinsa.application.record.ProductCreateDTO;
import com.henry.musinsa.application.record.ProductUpdateDTO;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.StringCustomUtils;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductCommandUseCase;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import java.text.ParseException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductRepositoryPort productRepository;

    @Override
    @Transactional
    public Product createProduct(ProductCreateDTO productCreateDTO) {
        if(null == productCreateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_PRODUCT_DATA_EMPTY);
        }

        Product createProduct = Product.builder()
                .title(productCreateDTO.getTitle())
                .price(productCreateDTO.getPrice())
                .salePrice(productCreateDTO.getSalePrice())
                .brand(productCreateDTO.getBrand())
                .category(productCreateDTO.getCategory())
                .build();
        return productRepository.save(createProduct);
    }

    @Override
    @Transactional
    public Product updateProduct(ProductUpdateDTO productUpdateDTO) {
        if(null == productUpdateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_BRAND_DATA_EMPTY);
        }

        productRepository.findActiveProductById(productUpdateDTO.getId()).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));

        Product updateProduct = Product.builder()
                .id(productUpdateDTO.getId())
                .title(productUpdateDTO.getTitle())
                .price(productUpdateDTO.getPrice())
                .salePrice(productUpdateDTO.getSalePrice())
                .brand(productUpdateDTO.getBrand())
                .category(productUpdateDTO.getCategory())
                .build();

        return productRepository.save(updateProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));
        product.delete();
        productRepository.save(product);
    }
}

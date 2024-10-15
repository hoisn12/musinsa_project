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

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductRepositoryPort productRepository;

    @Override
    public Product createProduct(ProductCreateDTO productCreateDTO) {
        if(null == productCreateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_PRODUCT_DATA_EMPTY);
        }

        Product createProduct = Product.builder()
                .title(productCreateDTO.title())
                .price(productCreateDTO.price())
                .salePrice(productCreateDTO.salePrice())
                .brand(productCreateDTO.brand())
                .category(productCreateDTO.category())
                .build();
        return productRepository.save(createProduct);
    }

    @Override
    public Product updateProduct(ProductUpdateDTO productUpdateDTO) {
        if(null == productUpdateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_BRAND_DATA_EMPTY);
        }

        productRepository.findActiveProductById(productUpdateDTO.id()).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));

        try {

            Product updateProduct = Product.builder()
                    .id(productUpdateDTO.id())
                    .title(productUpdateDTO.title())
                    .price(productUpdateDTO.price())
                    .salePrice(productUpdateDTO.salePrice())
                    .brand(productUpdateDTO.brand())
                    .category(productUpdateDTO.category())
                    .build();

            return productRepository.save(updateProduct);
        } catch (ParseException e) {
            throw new ApplicationException(ErrorCode.DATE_FORMAT_MISMATCH);
        }
    }

    @Override
    public void deleteProduct(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));
        product.delete();
        productRepository.save(product);
    }
}

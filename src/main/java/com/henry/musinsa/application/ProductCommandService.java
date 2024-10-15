package com.henry.musinsa.application;

import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.application.dto.ProductUpdateDTO;
import com.henry.musinsa.application.mappers.ProductCreateMapper;
import com.henry.musinsa.application.mappers.ProductUpdateMapper;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductCommandUseCase;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductCommandService implements ProductCommandUseCase {

    private final ProductRepositoryPort productRepository;
    private final ProductCreateMapper productCreateMapper;
    private final ProductUpdateMapper productUpdateMapper;

    @Override
    @Transactional
    public Product createProduct(ProductCreateDTO productCreateDTO) {
        if(null == productCreateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_PRODUCT_DATA_EMPTY);
        }

        Product createProduct = productCreateMapper.toDomain(productCreateDTO);

        return productRepository.save(createProduct);
    }

    @Override
    public List<Product> createProduct(List<ProductCreateDTO> productCreateDTOList) {
        if(ObjectUtils.isEmpty(productCreateDTOList)) {
            throw new ApplicationException(ErrorCode.CREATE_PRODUCT_DATA_EMPTY);
        }

        List<Product> createProductList = productCreateMapper.toDomain(productCreateDTOList);

        return productRepository.saveAll(createProductList);
    }

    @Override
    @Transactional
    public Product updateProduct(ProductUpdateDTO productUpdateDTO) {
        if(null == productUpdateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_BRAND_DATA_EMPTY);
        }

        Product originProduct = productRepository.findActiveProductById(productUpdateDTO.getId()).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));
        Product updateProduct = productUpdateMapper.toUpdateDomain(originProduct, productUpdateDTO);

        return productRepository.save(updateProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(String productId) {
        Product product = productRepository.findActiveProductById(productId).orElseThrow(() -> new ApplicationException(ErrorCode.PRODUCT_NOT_FOUND));
        product.delete();
        productRepository.save(product);
    }
}

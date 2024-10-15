package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.application.dto.ProductUpdateDTO;
import com.henry.musinsa.domain.Product;

import java.util.List;


public interface ProductCommandUseCase {

    /**
     * 상품 생성 (단건)
     * @param productCommandDTO 상품 데이터
     * @return Product 상품 도메인
     */
    Product createProduct(ProductCreateDTO productCommandDTO);

    /**
     * 상품 생성 (복수)
     * @param productCreateDTOList 상품 데이터 리스트
     * @return Product 상품 도메인 리스트
     */
    List<Product> createProduct(List<ProductCreateDTO> productCreateDTOList);

    /**
     * 상품 수정
     * @param productUpdateDTO 상품 데이터
     * @return Product 도메인
     */
    Product updateProduct(ProductUpdateDTO productUpdateDTO);

    /**
     * 상품 삭제
     * @param productId 상품 ID
     */
    void deleteProduct(String productId);

}

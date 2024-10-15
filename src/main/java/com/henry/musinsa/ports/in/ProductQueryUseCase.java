package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.application.dto.ProductLowestAndHighestDTO;
import com.henry.musinsa.application.dto.ProductLowestAndHighestResponseDTO;
import com.henry.musinsa.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductQueryUseCase {

    /**
     * 상품 전체 조회
     * @return Product 상품 리스트
     */
    List<Product> getAllProducts();

    /**
     * id 기준 상품 조회
     * @param id 상품 id
     * @return Product 도메인
     */
    Optional<Product> getProductById(String id);

    /**
     * 카테고리별 최저가격 브랜드 조회
     * @return response
     */
    CategoryPriceSummaryDTO getLowestPriceByCategoryAndBrand();

    /**
     * 단일 브랜드의 모든 카테고리 상품금액 합이 가장 낮은 브랜 조회
     * @return response
     */
    BrandSumPriceSummaryDTO getLowestPriceForAllCategoriesByBrand();

    /**
     * 카테고리명으로 최소,최대 금액 상품의 브랜드와 금액 조회
     * @param categoryName 카테고리명
     * @return response
     */
    ProductLowestAndHighestResponseDTO getLowestAndHighestPriceBrandsByCategory(String categoryName);
}

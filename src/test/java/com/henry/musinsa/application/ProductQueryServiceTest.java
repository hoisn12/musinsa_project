package com.henry.musinsa.application;

import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.application.record.CategoryPriceDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ProductQueryServiceTest {

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductRepositoryPort productRepository;

    @InjectMocks
    private ProductQueryService productService;

    private Product product1;
    private Product product2;

    @DisplayName("전체 상품을 조회한다.")
    @Test
    void testGetAllProducts() {
        // given
        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Product 1", products.get(0).getTitle());
        assertEquals("Product 2", products.get(1).getTitle());

        verify(productMapper, times(1)).toEntity(product1);
        verify(productMapper, times(1)).toEntity(product2);
    }

    @DisplayName("카테고리별 최저가격 브랜드와 상품가격,총액을 조회한다.")
    @Test
    void testGetLowestPriceByCategoryAndBrandUseCase() {
        // given
        CategoryPriceDTO mockCategoryPrice1 = CategoryPriceDTO.builder().categoryTitle("product 1").brandTitle("brand 1").price(1000.0).build();
        CategoryPriceDTO mockCategoryPrice2 = CategoryPriceDTO.builder().categoryTitle("product 2").brandTitle("brand 2").price(9000.0).build();
        Double sumPrice = mockCategoryPrice1.price() + mockCategoryPrice2.price();
        CategoryPriceSummaryDTO mockCategoryPriceSummary =  CategoryPriceSummaryDTO.builder()
                .categoryPriceList(List.of(mockCategoryPrice1, mockCategoryPrice2))
                .sumPrice(sumPrice)
                .build();
        when(productRepository.findLowestPriceByCategoryAndBrand()).thenReturn(mockCategoryPriceSummary);

        // when
        CategoryPriceSummaryDTO categoryPriceSummaryDTO = productService.getLowestPriceByCategoryAndBrandUseCase();

        // then
        assertNotNull(categoryPriceSummaryDTO);
        assertNotNull(categoryPriceSummaryDTO.categoryPriceList());
        assertNotNull(categoryPriceSummaryDTO.sumPrice());
        assertEquals(categoryPriceSummaryDTO.sumPrice(),
                categoryPriceSummaryDTO.categoryPriceList().stream().mapToDouble(CategoryPriceDTO::price).sum());
        assertEquals(mockCategoryPriceSummary.categoryPriceList().size(), categoryPriceSummaryDTO.categoryPriceList().size());
        verify(productRepository, times(1)).findLowestPriceByCategoryAndBrand();
    }

    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격,총액을조회한다.")
    @Test
    void testGetLowestPriceForAllCategoriesByBrand() {
        // given
        CategoryPriceDTO mockCategoryPrice1 = CategoryPriceDTO.builder().categoryTitle("product 1").brandTitle("brand 1").price(1000.0).build();
        CategoryPriceDTO mockCategoryPrice2 = CategoryPriceDTO.builder().categoryTitle("product 2").brandTitle("brand 2").price(9000.0).build();
        Double sumPrice = mockCategoryPrice1.price() + mockCategoryPrice2.price();
        CategoryPriceSummaryDTO mockCategoryPriceSummary =  CategoryPriceSummaryDTO.builder()
                .categoryPriceList(List.of(mockCategoryPrice1, mockCategoryPrice2))
                .sumPrice(sumPrice)
                .build();
        when(productRepository.findLowestPriceByCategoryAndBrand()).thenReturn(mockCategoryPriceSummary);

        // when
        CategoryPriceSummaryDTO categoryPriceSummaryDTO = productService.getLowestPriceByCategoryAndBrandUseCase();

        // then
        assertNotNull(categoryPriceSummaryDTO);
        assertNotNull(categoryPriceSummaryDTO.categoryPriceList());
        assertNotNull(categoryPriceSummaryDTO.sumPrice());
        assertEquals(categoryPriceSummaryDTO.sumPrice(),
                categoryPriceSummaryDTO.categoryPriceList().stream().mapToDouble(CategoryPriceDTO::price).sum());
        assertEquals(mockCategoryPriceSummary.categoryPriceList().size(), categoryPriceSummaryDTO.categoryPriceList().size());
        verify(productRepository, times(1)).findLowestPriceByCategoryAndBrand();
    }
}
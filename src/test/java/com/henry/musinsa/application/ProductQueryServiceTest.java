package com.henry.musinsa.application;

import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.application.dto.BrandSumPriceDTO;
import com.henry.musinsa.application.dto.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.dto.CategoryPriceDTO;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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

    private ProductCategory productCategory1;
    private ProductCategory productCategory2;
    private Brand brand1;
    private Brand brand2;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;


    @BeforeEach
    void setUp() {
        productCategory1 = ProductCategory.builder().id("CA11").title("상의").build();
        productCategory2 = ProductCategory.builder().id("CA22").title("하의").build();

        brand1 = Brand.builder().id("B11").title("A").build();
        brand2 = Brand.builder().id("B22").title("B").build();

        product1 = Product.builder().id("PRO11").title("product A").category(productCategory1).brand(brand1).price(1000.0).salePrice(1000.0).build();
        product2 = Product.builder().id("PRO22").title("product B").category(productCategory1).brand(brand2).price(2000.0).salePrice(2000.0).build();
        product3 = Product.builder().id("PRO33").title("product C").category(productCategory2).brand(brand1).price(1500.0).salePrice(1500.0).build();
        product4 = Product.builder().id("PRO44").title("product D").category(productCategory2).brand(brand2).price(1200.0).salePrice(1200.0).build();

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
        CategoryPriceSummaryDTO categoryPriceSummaryDTO = productService.getLowestPriceByCategoryAndBrand();

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
        BrandSumPriceDTO brandSumPriceDTO = BrandSumPriceDTO.builder()
                .brandId(brand1.getId())
                .brandTitle(brand1.getTitle())
                .sumPrice(2000.0)
                .build();
        when(productRepository.findBrandWithLowestTotalPrice()).thenReturn(brandSumPriceDTO);
        when(productRepository.findLowestPriceForAllCategoriesByBrand(brand1.getId())).thenReturn(List.of(product1,product3));

        // when
        BrandSumPriceSummaryDTO brandSumPriceSummaryDTO = productService.getLowestPriceForAllCategoriesByBrand();

        // then
        assertNotNull(brandSumPriceSummaryDTO);
        assertNotNull(brandSumPriceSummaryDTO.minPrice());
        // 총합 비교
        assertEquals(brandSumPriceSummaryDTO.minPrice().getSumPrice(), 2000.0);
        // category price 개수비교
        assertEquals(brandSumPriceSummaryDTO.minPrice().getCategoryPriceList().size(), 2);

        // 호출여부
        verify(productRepository, times(1)).findBrandWithLowestTotalPrice();
        verify(productRepository, times(1)).findLowestPriceForAllCategoriesByBrand(brand1.getId());

    }
}
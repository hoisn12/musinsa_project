package com.henry.musinsa.application;

import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.out.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class ProductQueryServiceTest {

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductQueryService productService;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product1 = Product.builder()
                .id(1L)
                .title("Product 1")
                .price(1000.0)
                .salePrice(900.0)
                .build();

        product2 = Product.builder()
                .id(2L)
                .title("Product 2")
                .price(1500.0)
                .salePrice(900.0)
                .build();
    }

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

    @DisplayName("카테고리별 최저가격을 조회한다.")
    @Test
    void testGetLowestPriceForCategoryUseCase() {
        List<Product> mockProducts = Arrays.asList(product1, product2);
        CategoryPriceSummaryDTO categoryPriceSummaryDTO = productService.getLowestPriceForCategoryUseCase();
        assertEquals(2, categoryPriceSummaryDTO.categoryPriceDTOList().size());
    }

}
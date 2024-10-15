package com.henry.musinsa.application;

import com.henry.musinsa.application.dto.*;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import com.henry.musinsa.ports.out.ProductCategoryRepositoryPort;
import com.henry.musinsa.ports.out.ProductRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductQueryService implements ProductQueryUseCase {

    private final ProductRepositoryPort productRepository;
    private final ProductCategoryRepositoryPort productCategoryRepositoryPort;


    @Override
    @Cacheable(value = "products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryPriceSummaryDTO getLowestPriceByCategoryAndBrandUseCase() {
        return productRepository.findLowestPriceByCategoryAndBrand();
    }

    @Override
    public BrandSumPriceSummaryDTO getLowestPriceForAllCategoriesByBrand() {
        BrandSumPriceDTO lowestBrand = productRepository.findBrandWithLowestTotalPrice();
        List<Product> productList = productRepository.findLowestPriceForAllCategoriesByBrand(lowestBrand.brandId());

        List<CategoryPriceDTO> categoryPriceDTOList = new ArrayList<>();
        for(Product product : productList) {
            categoryPriceDTOList.add(CategoryPriceDTO.builder()
                    .categoryTitle(product.getCategory().getTitle())
                    .price(product.getSalePrice())
                    .build());
        }
        return BrandSumPriceSummaryDTO.builder()
                .brandTitle(lowestBrand.brandTitle())
                .sumPrice(lowestBrand.sumPrice())
                .categoryPriceList(categoryPriceDTOList)
                .build();
    }

    @Override
    public ProductLowestAndHighestResponseDTO getLowestAndHighestPriceBrandsByCategory(String categoryName) {
        List<Product> minProductList = productRepository.findMinPriceProductsByCategoryName(categoryName);
        List<Product> maxProductList = productRepository.findMaxPriceProductsByCategoryName(categoryName);

        String title = minProductList.get(0).getCategory().getTitle();

        List<ProductLowestAndHighestResponseDTO.BrandPrice> minBrandList = new ArrayList<>();
        List<ProductLowestAndHighestResponseDTO.BrandPrice> maxBrandList = new ArrayList<>();

        for(Product product : minProductList) {
            minBrandList.add(ProductLowestAndHighestResponseDTO.BrandPrice.builder()
                    .brandName(product.getBrand().getTitle())
                    .price(product.getSalePrice()).build());
        }
        for(Product product : maxProductList) {
            maxBrandList.add(ProductLowestAndHighestResponseDTO.BrandPrice.builder()
                    .brandName(product.getBrand().getTitle())
                    .price(product.getSalePrice()).build());
        }

        return ProductLowestAndHighestResponseDTO.builder()
                .categoryName(title)
                .maxPrice(maxBrandList)
                .minPrice(minBrandList)
                .build();

    }
}

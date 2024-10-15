package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.adapters.in.web.mappers.ProductCommandMapper;
import com.henry.musinsa.application.dto.*;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.ports.in.BrandQueryUseCase;
import com.henry.musinsa.ports.in.ProductCategoryQueryUseCase;
import com.henry.musinsa.ports.in.ProductCommandUseCase;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
@SuppressWarnings("unused")
public class ProductController {

    private final ProductQueryUseCase productUseCase;
    private final ProductCommandUseCase productCommandUseCase;
    private final ProductCategoryQueryUseCase productCategoryQueryUseCase;
    private final BrandQueryUseCase brandQueryUseCase;
    private final ProductCommandMapper productCommandMapper;

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        ProductCategory productCategory = productCategoryQueryUseCase.getProductCategory(productCreateDTO.getCategoryId());
        Brand brand = brandQueryUseCase.getBrand(productCreateDTO.getBrandId());
        productCreateDTO.setBrand(brand);
        productCreateDTO.setCategory(productCategory);
        Product result = productCommandUseCase.createProduct(productCreateDTO);
        return ResEntity.success(productCommandMapper.toCreateResponse(result, brand, productCategory));
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductCategory productCategory = productCategoryQueryUseCase.getProductCategory(productUpdateDTO.getCategoryId());
        Brand brand = brandQueryUseCase.getBrand(productUpdateDTO.getBrandId());
        productUpdateDTO.setBrand(brand);
        productUpdateDTO.setCategory(productCategory);
        Product result = productCommandUseCase.updateProduct(productUpdateDTO);
        return ResEntity.success(productCommandMapper.toUpdateResponse(result, brand, productCategory));
    }

    @GetMapping("/prices/lowest/category")
    public ResponseEntity<?> getLowestPriceByCategoryAndBrand() {
        CategoryPriceSummaryDTO categoryPriceSummaryDTO = productUseCase.getLowestPriceByCategoryAndBrandUseCase();
        return ResEntity.success(categoryPriceSummaryDTO);
    }

    @GetMapping("/prices/lowest/brand")
    public ResponseEntity<?> getLowestPriceForAllCategoriesByBrand() {
        BrandSumPriceSummaryDTO result = productUseCase.getLowestPriceForAllCategoriesByBrand();
        return ResEntity.success(result);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) {
        if(null == productId) {
            return ResEntity.fail(ErrorCode.PRODUCT_NOT_FOUND);
        }
        productCommandUseCase.deleteProduct(productId);
        return ResEntity.success();
    }
    @GetMapping("/category/lowhigh")
    public ResponseEntity<?> getLowestAndHighestPriceBrandsByCategory(@RequestParam("name") String categoryName) {
        if(null == categoryName) {
            return ResEntity.fail(ErrorCode.REQUIRE_PRODUCT_CATEGORY_TITLE);
        }

        return ResEntity.success(productUseCase.getLowestAndHighestPriceBrandsByCategory(categoryName));

    }
}

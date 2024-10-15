package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.application.record.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.application.record.ProductCreateDTO;
import com.henry.musinsa.application.record.ProductUpdateDTO;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.ports.in.BrandQueryUseCase;
import com.henry.musinsa.ports.in.ProductCategoryQueryUseCase;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
@SuppressWarnings("unused")
public class ProductController {

    private final ProductQueryUseCase productUseCase;
    private final ProductCategoryQueryUseCase productCategoryQueryUseCase;
    private final BrandQueryUseCase brandQueryUseCase;

    @GetMapping
    public ResponseEntity<?> getProductAll() {
        productUseCase.getAllProducts();
        return ResEntity.success();
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

    @PostMapping
    public ResponseEntity<?> createProduct(ProductCreateDTO productCreateDTO) {
        ProductCategory productCategory = productCategoryQueryUseCase.getProductCategory(productCreateDTO.getCategoryId());
        Brand brand = brandQueryUseCase.getBrand(productCreateDTO.getBrandId());
        return ResEntity.success();
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(ProductUpdateDTO productUpdateDTO) {
        return ResEntity.success();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) {
        return ResEntity.success();
    }
}

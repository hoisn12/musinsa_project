package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.application.record.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
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
    public ResponseEntity<?> createProduct() {
        return ResEntity.success();
    }

    @PutMapping
    public ResponseEntity<?> updateProduct() {
        return ResEntity.success();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId) {
        return ResEntity.success();
    }
}

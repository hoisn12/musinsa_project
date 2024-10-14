package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/lowest/category")
    public ResponseEntity<?> getLowestPriceForAllCategoriesByBrand() {
        productUseCase.getLowestPriceForAllCategoriesByBrand();
        return ResEntity.success();
    }


}

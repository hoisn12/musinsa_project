package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.ports.in.ProductUseCase;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity<?> getProductAll() {
        productUseCase.getAllProducts();
        return ResEntity.success();
    }
}

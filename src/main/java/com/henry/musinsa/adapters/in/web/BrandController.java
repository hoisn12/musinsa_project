package com.henry.musinsa.adapters.in.web;

import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brands")
@SuppressWarnings("unused")
public class BrandController {

    @PostMapping
    public ResponseEntity<?> createBrand() {

        return ResEntity.success();
    }

    @PutMapping
    public ResponseEntity<?> updateBrand() {
        return ResEntity.success();
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable("brandId") String brandId) {
        return ResEntity.success();
    }

}

package com.henry.musinsa.adapters.in.web;


import com.henry.musinsa.adapters.in.web.mappers.CategoryQueryMapper;
import com.henry.musinsa.adapters.out.persistence.mappers.ProductCategoryMapper;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.ports.in.ProductCategoryQueryUseCase;
import com.henry.musinsa.ports.out.ProductCategoryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
@SuppressWarnings("unused")
public class CategoryController {

    private final ProductCategoryQueryUseCase productCategoryQueryUseCase;
    private final CategoryQueryMapper categoryQueryMapper;

    @GetMapping
    public ResponseEntity<?> getAllCategory() {

        return ResEntity.success(categoryQueryMapper.toUpdateResponse(productCategoryQueryUseCase.getAllCategory()));
    }
}

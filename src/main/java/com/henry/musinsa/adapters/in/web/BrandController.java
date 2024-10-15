package com.henry.musinsa.adapters.in.web;

import com.henry.musinsa.application.dto.BrandCreateDTO;
import com.henry.musinsa.application.dto.BrandCreateResponseDTO;
import com.henry.musinsa.application.dto.BrandUpdateDTO;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.StringCustomUtils;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.ports.in.BrandCommandUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/brands")
@SuppressWarnings("unused")
public class BrandController {
    private final BrandCommandUseCase brandCommandUseCase;

    @PostMapping
    public ResponseEntity<?> createBrand(@Valid @RequestBody BrandCreateDTO brandCreateDTO) {
        Brand result = brandCommandUseCase.createBrand(brandCreateDTO);

        return ResEntity.success(BrandCreateResponseDTO.builder()
                .brandId(result.getId())
                .brandTitle(result.getTitle())
                .brandId(result.getId())
                .description(result.getDescription())
                .joinDate(StringCustomUtils.localDateToString(result.getJoinDate(), "yyyyMMdd"))
                .localDelivery(result.getIsLocalDelivery())
                .privateBrand(result.getIsPrivateBrand()).build());
    }

    @PutMapping
    public ResponseEntity<?> updateBrand(@Valid @RequestBody BrandUpdateDTO brandUpdateDTO) {
        Brand result = brandCommandUseCase.updateBrand(brandUpdateDTO);

        return ResEntity.success(BrandCreateResponseDTO.builder()
                .brandId(result.getId())
                .brandTitle(result.getTitle())
                .brandId(result.getId())
                .description(result.getDescription())
                .joinDate(StringCustomUtils.localDateToString(result.getJoinDate(), "yyyyMMdd"))
                .localDelivery(result.getIsLocalDelivery())
                .privateBrand(result.getIsPrivateBrand()).build());

    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable("brandId") String brandId) {
        if(null == brandId) {
            return ResEntity.fail(ErrorCode.BRAND_NOT_FOUND);
        }
        brandCommandUseCase.deleteBrand(brandId);
        return ResEntity.success();
    }

}

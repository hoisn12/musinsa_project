package com.henry.musinsa.application.dto;

import lombok.Builder;

@Builder
public record BrandSumPriceDTO(
        String brandId,
        String brandTitle,
        Double sumPrice
) {
}

package com.henry.musinsa.application.record;

import lombok.Builder;

@Builder
public record BrandSumPriceDTO(
        String brandId,
        String brandTitle,
        Double sumPrice
) {
}

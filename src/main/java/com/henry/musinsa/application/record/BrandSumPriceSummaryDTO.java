package com.henry.musinsa.application.record;

import lombok.Builder;

import java.util.List;

@Builder
public record BrandSumPriceSummaryDTO(
        String brandTitle,
        Double sumPrice,
        List<CategoryPriceDTO> categoryPriceList
) {

}

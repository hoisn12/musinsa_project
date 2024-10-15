package com.henry.musinsa.application.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record BrandSumPriceSummaryDTO(
        String brandTitle,
        Double sumPrice,
        List<CategoryPriceDTO> categoryPriceList
) {

}

package com.henry.musinsa.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record BrandSumPriceSummaryDTO(
        MinPrice minPrice
) {

    @Data
    @Builder
    public static class MinPrice {
        private String brandTitle;
        private Double sumPrice;
        private List<CategoryPriceDTO> categoryPriceList;
    }

}

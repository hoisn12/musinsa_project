package com.henry.musinsa.application.record;


import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
public record AllCategoryPriceForBrandSummaryDTO(
        LowestPriceForBrand lowestPrice
) {
    @Getter
    @Builder
    public static class LowestPriceForBrand {
        String brandTitle;
        List<BrandCategoryPrice> categoryPriceList;
        Double sumPrice;
    }

    @Getter
    @Builder
    public static class BrandCategoryPrice {
        private String categoryTitle;
        private Double price;
    }
}

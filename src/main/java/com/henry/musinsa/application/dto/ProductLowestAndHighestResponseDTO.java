package com.henry.musinsa.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder(toBuilder = true)
public class ProductLowestAndHighestResponseDTO {
        String categoryName;
        List<BrandPrice> minPrice;
        List<BrandPrice> maxPrice;

        @Data
        @Builder
        public static class BrandPrice {
                private String brandName;
                private Double price;
        }
}

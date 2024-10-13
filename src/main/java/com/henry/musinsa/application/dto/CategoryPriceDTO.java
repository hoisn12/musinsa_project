package com.henry.musinsa.application.dto;

import lombok.Builder;

@Builder
public record CategoryPriceDTO(
        String categoryTitle,
        String brandTitle,
        Double price,
        Double sumPrice
) {
}

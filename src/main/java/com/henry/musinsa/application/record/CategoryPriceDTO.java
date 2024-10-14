package com.henry.musinsa.application.record;

import lombok.Builder;

@Builder
public record CategoryPriceDTO(
        String categoryTitle,
        String brandTitle,
        Double price
) {
}

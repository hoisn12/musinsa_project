package com.henry.musinsa.application.dto;


import lombok.Builder;

import java.util.List;

@Builder
public record CategoryPriceSummaryDTO (
        List<CategoryPriceDTO> categoryPriceDTOList,
        Double sumPrice
) {
}

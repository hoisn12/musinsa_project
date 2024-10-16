package com.henry.musinsa.application.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record CategoryPriceSummaryDTO (
        List<CategoryPriceDTO> categoryPriceList,
        Double sumPrice
) {
}

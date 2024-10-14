package com.henry.musinsa.application.record;


import lombok.Builder;

import java.util.List;

@Builder
public record CategoryPriceSummaryDTO (
        List<CategoryPriceDTO> categoryPriceList,
        Double sumPrice
) {
}

package com.henry.musinsa.application.dto;

import lombok.Builder;


@Builder
public record BrandCreateResponseDTO(
        String brandId,
        String brandTitle,
        String description,
        String joinDate,
        String endDate,
        Boolean localDelivery,
        Boolean privateBrand
) {

}

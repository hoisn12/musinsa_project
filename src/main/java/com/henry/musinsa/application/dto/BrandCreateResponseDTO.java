package com.henry.musinsa.application.dto;

import lombok.Builder;


@Builder
public record BrandCreateResponseDTO(
        String brandId,
        String brandTitle,
        String description,
        String joinDate,
        Boolean localDelivery,
        Boolean privateBrand
) {

}

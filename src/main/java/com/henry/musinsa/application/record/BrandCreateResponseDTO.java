package com.henry.musinsa.application.record;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

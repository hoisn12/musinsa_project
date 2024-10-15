package com.henry.musinsa.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryPriceDTO(
        @JsonProperty("categoryTitle")
        String categoryTitle,
        @JsonProperty("brandTitle")
        String brandTitle,
        Double price
) {
}

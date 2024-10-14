package com.henry.musinsa.application.record;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

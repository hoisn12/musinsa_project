package com.henry.musinsa.application.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CategoryResponseDTO(
        String id,
        String title
) {

}

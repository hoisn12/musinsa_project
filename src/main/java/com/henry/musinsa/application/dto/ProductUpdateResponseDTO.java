package com.henry.musinsa.application.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductUpdateResponseDTO {
        private String id;
        private String title;
        private String description;
        private Double price;
        private Double salePrice;
        private String brandId;
        private String brandTitle;
        private String categoryId;
        private String categoryTitle;
}

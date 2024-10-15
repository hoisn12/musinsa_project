package com.henry.musinsa.application.dto;

import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductCreateDTO {
        @NotBlank(message = "상품명은 필수입니다.")
        private String title;

        @NotNull(message = "상품 금액은 필수입니다.")
        private Double price;

        @NotNull(message = "할인가는 필수입니다.")
        private Double salePrice;

        @NotBlank(message = "브랜드 ID는 필수입니다.")
        private String brandId;

        @NotBlank(message = "카테고리 ID는 필수입니다.")
        private String categoryId;

        private Brand brand;
        private ProductCategory category;
}

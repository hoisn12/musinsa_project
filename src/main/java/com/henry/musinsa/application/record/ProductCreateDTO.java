package com.henry.musinsa.application.record;

import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record ProductCreateDTO(
        String id,
        @NotBlank(message = "상품명은 필수입니다.")
        String title,
        @NotBlank(message = "상품 금액은 필수입니다.")
        Double price,
        @NotBlank(message = "할인가는 필수입니다.")
        Double salePrice,
        @NotBlank(message = "브랜드 ID는 필수입니다.")
        String brandId,
        @NotBlank(message = "카테고리 ID는 필수입니다.")
        String categoryId,
        Brand brand,
        ProductCategory category
) {

}

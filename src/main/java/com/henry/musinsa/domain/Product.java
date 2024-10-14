package com.henry.musinsa.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private String id;
    private String title;
    private Double price;
    private Double salePrice;
    private Brand brand;
    @Default
    private Boolean isDel = false;
    private ProductCategory category;
    private Long creatorId;
    private LocalDateTime createdAt;
    private Long updaterId;
    private LocalDateTime updatedAt;
}

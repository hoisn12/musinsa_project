package com.henry.musinsa.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private Long id;
    private String title;
    private Double price;
    private Double salePrice;
    private Long brandId;
    private Long categoryId;
    private Brand brand;
    private ProductCategory category;
}

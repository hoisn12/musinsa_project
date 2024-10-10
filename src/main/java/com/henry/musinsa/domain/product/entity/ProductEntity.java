package com.henry.musinsa.domain.product.entity;

import com.henry.musinsa.domain.CommonEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends CommonEntity {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @Column(name = "sale_price")
    private String salePrice;

    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "category_id")
    private Long categoryId;

}

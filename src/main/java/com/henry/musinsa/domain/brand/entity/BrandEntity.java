package com.henry.musinsa.domain.brand.entity;

import com.henry.musinsa.domain.CommonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BrandEntity extends CommonEntity {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_del")
    private boolean isDel;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "country")
    private String country;

    @Column(name = "is_local_delivery")
    private boolean isLocalDelivery;

    @Column(name = "is_private_brand")
    private boolean isPrivateBrand;
}

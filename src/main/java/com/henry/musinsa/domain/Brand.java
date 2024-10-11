package com.henry.musinsa.domain;


import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Brand {

    private Long seq;
    private String title;
    private String description;
    private boolean isDel;
    private LocalDate joinDate;
    private LocalDate endDate;
    private String country;
    private boolean isLocalDelivery;
    private boolean isPrivateBrand;
}

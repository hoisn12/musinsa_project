package com.henry.musinsa.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
@Builder
public class Brand {

    private String id;
    private String title;
    private String description;
    @Default
    private Boolean isDel = false;
    private LocalDate joinDate;
    private LocalDate endDate;
    private Long creatorId;
    @Default
    private LocalDateTime createdAt = LocalDateTime.now();
    private Long updaterId;
    @Default
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Default
    private Boolean isLocalDelivery = true;
    @Default
    private Boolean isPrivateBrand = false;

    private Long version;

    public void delete() {
        this.isDel = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void changeJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void changeEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

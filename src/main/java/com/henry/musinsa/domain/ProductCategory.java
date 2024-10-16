package com.henry.musinsa.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductCategory {
    private String id;
    private String title;
    private Boolean isDel;
    private Long creatorId;
    private LocalDateTime createdAt;
    private Long updaterId;
    private LocalDateTime updatedAt;
    
}

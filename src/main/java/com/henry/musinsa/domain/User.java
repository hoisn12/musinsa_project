package com.henry.musinsa.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
@Builder
public class User{
    private Long id;
    private String name;
    @Default
    private Boolean isAdmin = false;
    private Long creatorId;
    private LocalDateTime createdAt;
    private Long updaterId;
    private LocalDateTime updatedAt;

}

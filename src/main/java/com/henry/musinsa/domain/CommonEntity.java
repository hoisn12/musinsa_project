package com.henry.musinsa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class CommonEntity {

    @Column(name = "creator_id")
    private Long creatorId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updater_id")
    private Long updaterId;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

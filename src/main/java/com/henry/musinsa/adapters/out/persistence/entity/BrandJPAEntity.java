package com.henry.musinsa.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.ObjectUtils;

@Getter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "brand",indexes = {
        @Index(name = "brand_id_idx", columnList = "id", unique = true)
})
public class BrandJPAEntity extends CommonEntity {
    @PrePersist
    public void prePersist() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.id = ObjectUtils.isEmpty(this.id) ? uuid : this.id;
    }

    @Id
    @Comment("식별자")
    private String id;

    @Comment("브랜드 명")
    @Column(name = "title")
    private String title;

    @Comment("브랜드 설명")
    @Column(name = "description")
    private String description;

    @Comment("삭제여부")
    @Column(name = "is_del")
    private Boolean isDel;

    @Comment("입점일")
    @Column(name = "join_date")
    private LocalDate joinDate;

    @Comment("퇴점일")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Comment("국가")
    @Column(name = "country")
    private String country;

    @Comment("국내배송 여부")
    @Column(name = "is_local_delivery")
    private Boolean isLocalDelivery;

    @Comment("자체 브랜드 여부")
    @Column(name = "is_private_brand")
    private Boolean isPrivateBrand;
    @Builder.Default
    @Version
    private Long version = 0L;
}

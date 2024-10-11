package com.henry.musinsa.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "brand")
public class BrandJPAEntity extends CommonEntity {

    @Id
    @SequenceGenerator(name = "brand_id_seq_gen", sequenceName = "brand_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_id_seq_gen")
    @Comment("식별자")
    private Long seq;

    @Comment("브랜드 명")
    @Column(name = "title")
    private String title;

    @Comment("브랜드 설명")
    @Column(name = "description")
    private String description;

    @Comment("삭제여부")
    @Column(name = "is_del")
    private boolean isDel;

    @Comment("입점일")
    @Column(name = "join_date")
    private LocalDate joinDate;

    @Comment("폐점일")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Comment("국가")
    @Column(name = "country")
    private String country;

    @Comment("국내배송 여부")
    @Column(name = "is_local_delivery")
    private boolean isLocalDelivery;

    @Comment("자체 브랜드 여부")
    @Column(name = "is_private_brand")
    private boolean isPrivateBrand;
}

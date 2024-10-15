package com.henry.musinsa.adapters.out.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.util.ObjectUtils;

@Getter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product",indexes = {
        @Index(name = "product_id_idx", columnList = "id", unique = true)
})
public class ProductJPAEntity extends CommonEntity {
    @PrePersist
    public void prePersist() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        this.id = ObjectUtils.isEmpty(this.id) ? uuid : this.id;
    }

    @Id
    @Comment("식별자")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "price", columnDefinition = "double default 0.0")
    private Double price;

    @Column(name = "sale_price", columnDefinition = "double default 0.0")
    private Double salePrice;

    @Default
    @Column(name = "is_del", columnDefinition = "boolean default false")
    private Boolean isDel = false;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BrandJPAEntity brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductCategoryJPAEntity category;

    @Version
    private Long version;
}

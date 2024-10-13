package com.henry.musinsa.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
public class ProductJPAEntity extends CommonEntity {

    @Id
    @SequenceGenerator(name = "product_id_seq_gen", sequenceName = "product_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq_gen")
    @Comment("식별자")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price", columnDefinition = "0.0")
    private Double price;

    @Column(name = "sale_price", columnDefinition = "0.0")
    private Double salePrice;

    @Column(name = "is_del", columnDefinition = "false")
    private boolean isDel;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BrandJPAEntity brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductCategoryJPAEntity category;

}

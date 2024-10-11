package com.henry.musinsa.adapters.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_category")
public class ProductCategoryJPAEntity extends CommonEntity{

    @Id
    @SequenceGenerator(name = "product_category_id_seq_gen", sequenceName = "product_category_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_category_id_seq_gen")
    @Comment("식별자")
    private Long id;

    @Column(name = "title")
    private String title;
    
}

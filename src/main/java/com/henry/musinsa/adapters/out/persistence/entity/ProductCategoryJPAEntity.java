package com.henry.musinsa.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
@Table(name = "product_category", indexes = {
        @Index(name = "product_category_id_idx", columnList = "id", unique = true)
})
public class ProductCategoryJPAEntity extends CommonEntity {
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

    @Version
    private Long version;
    
}

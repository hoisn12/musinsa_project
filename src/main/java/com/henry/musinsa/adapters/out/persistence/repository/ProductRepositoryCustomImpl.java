package com.henry.musinsa.adapters.out.persistence.repository;


import com.henry.musinsa.adapters.out.persistence.ProductJPAEntity;
import com.henry.musinsa.application.dto.CategoryPriceDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.henry.musinsa.adapters.out.persistence.QProductJPAEntity.productJPAEntity;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryPriceDTO> findLowestPriceProductByCategory() {

        return queryFactory
                .select(
                        Projections.constructor(
                                CategoryPriceDTO.class,
                                productJPAEntity.category.title.as("categoryTitle"),
                                productJPAEntity.brand.title.as("brandTitle"),
                                productJPAEntity.salePrice.min().as("price")
                        )
                )
                .from(productJPAEntity)
                .where(productJPAEntity.isDel.isFalse())
                .groupBy(productJPAEntity.category.title, productJPAEntity.brand.title)
                .fetch();

    }

    @Override
    public List<ProductJPAEntity> findLowestPriceBrandForAllCategories() {
        return List.of();
    }

    @Override
    public List<ProductJPAEntity> findLowestAndHighestPriceBrandsByCategory() {
        return List.of();
    }
}

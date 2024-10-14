package com.henry.musinsa.adapters.out.persistence.repository.custom;


import static com.henry.musinsa.adapters.out.persistence.entity.QProductJPAEntity.productJPAEntity;
import static com.henry.musinsa.adapters.out.persistence.entity.QProductCategoryJPAEntity.productCategoryJPAEntity;
import static com.henry.musinsa.adapters.out.persistence.entity.QBrandJPAEntity.brandJPAEntity;

import com.henry.musinsa.adapters.out.persistence.entity.BrandJPAEntity;
import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;

import com.henry.musinsa.adapters.out.persistence.entity.QBrandJPAEntity;
import com.henry.musinsa.adapters.out.persistence.entity.QProductJPAEntity;
import com.henry.musinsa.application.record.CategoryPriceDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<CategoryPriceDTO> findLowestPriceByCategoryAndBrand() {
        QProductJPAEntity productSub = new QProductJPAEntity("productSub");
        QBrandJPAEntity brandSub = new QBrandJPAEntity("brandSub");

        return queryFactory
                .select(
                        Projections.constructor(
                                CategoryPriceDTO.class,
                                productCategoryJPAEntity.title.as("categoryTitle"),
                                brandJPAEntity.title.as("brandTitle"),
                                productJPAEntity.salePrice.as("price")
                        )
                )
                .from(productCategoryJPAEntity,productJPAEntity,brandJPAEntity)
                .where(productJPAEntity.category.eq(productCategoryJPAEntity))
                .where(productJPAEntity.brand.eq(brandJPAEntity))
                .where(productJPAEntity.isDel.isFalse())
                .where(productJPAEntity.id.eq(
                        JPAExpressions.select(productSub.id)
                        .from(productSub)
                        .join(productSub.brand, brandSub)
                        .where(productSub.isDel.isFalse())
                        .where(productSub.category.eq(productCategoryJPAEntity))
                        .groupBy(productSub.salePrice.min())
                        ))
                .fetch();
    }

    @Override
    public BrandJPAEntity findBrandWithLowestTotalPrice() {
//        return queryFactory.selectFrom()
        return null;
    }

    @Override
    public List<ProductJPAEntity> findLowestPriceForAllCategoriesByBrand() {
        return List.of();
    }

    @Override
    public List<ProductJPAEntity> findLowestAndHighestPriceBrandsByCategory() {
        return List.of();
    }
}

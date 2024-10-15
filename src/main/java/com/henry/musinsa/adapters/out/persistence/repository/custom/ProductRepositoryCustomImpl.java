package com.henry.musinsa.adapters.out.persistence.repository.custom;


import static com.henry.musinsa.adapters.out.persistence.entity.QProductJPAEntity.productJPAEntity;
import static com.henry.musinsa.adapters.out.persistence.entity.QProductCategoryJPAEntity.productCategoryJPAEntity;
import static com.henry.musinsa.adapters.out.persistence.entity.QBrandJPAEntity.brandJPAEntity;

import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;

import com.henry.musinsa.adapters.out.persistence.entity.QBrandJPAEntity;
import com.henry.musinsa.adapters.out.persistence.entity.QProductJPAEntity;
import com.henry.musinsa.application.dto.BrandSumPriceDTO;
import com.henry.musinsa.application.dto.CategoryPriceDTO;
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
                                brandJPAEntity.title.max().as("brandTitle"),
                                productJPAEntity.salePrice.as("price")
                        )
                )
                .from(productCategoryJPAEntity,productJPAEntity,brandJPAEntity)
                .where(productJPAEntity.category.eq(productCategoryJPAEntity))
                .where(productJPAEntity.brand.eq(brandJPAEntity))
                .where(productJPAEntity.isDel.isFalse())
                .where(productJPAEntity.salePrice.eq(
                        JPAExpressions.select(productSub.salePrice.min())
                        .from(productSub)
                        .join(productSub.brand, brandSub)
                        .where(productSub.isDel.isFalse())
                        .where(productSub.category.eq(productCategoryJPAEntity))
                        .groupBy(productSub.category)
                        ))
                .groupBy(productCategoryJPAEntity.title, productJPAEntity.salePrice )
                .fetch();
    }

    @Override
    public BrandSumPriceDTO findBrandWithLowestTotalPrice() {
        return queryFactory.select(
                    Projections.constructor(
                            BrandSumPriceDTO.class,
                            brandJPAEntity.id,
                            brandJPAEntity.title,
                            productJPAEntity.salePrice.sum()
                    )
                )
                .from(productJPAEntity)
                .join(productJPAEntity.brand, brandJPAEntity)
                .where(productJPAEntity.isDel.isFalse())
                .where(brandJPAEntity.isDel.isFalse())
                .groupBy(brandJPAEntity.id,brandJPAEntity.title)
                .orderBy(productJPAEntity.salePrice.sum().asc())
                .limit(1)
                .fetchOne();
    }

    @Override
    public List<ProductJPAEntity> findLowestPriceForAllCategoriesByBrand(String brandId) {
        return queryFactory.selectFrom(productJPAEntity)
                .join(productJPAEntity.category, productCategoryJPAEntity)
                .fetchJoin()
                .where(productJPAEntity.brand.id.eq(brandId))
                .where(productJPAEntity.brand.isDel.isFalse())
                .where(productJPAEntity.isDel.isFalse())
                .fetch();
    }

    @Override
    public List<ProductJPAEntity> findMaxPriceProductsByCategoryName(String categoryName) {

         Double maxPrice = queryFactory.select(productJPAEntity.salePrice.max())
                 .from(productJPAEntity)
                .join(productJPAEntity.category, productCategoryJPAEntity)
                .where(productJPAEntity.isDel.isFalse())
                .where(productCategoryJPAEntity.title.eq(categoryName))
                 .fetchOne();

        return queryFactory.selectFrom(productJPAEntity)
                .join(productJPAEntity.category, productCategoryJPAEntity)
                .join(productJPAEntity.brand, brandJPAEntity)
                .where(brandJPAEntity.isDel.isFalse())
                .where(productJPAEntity.isDel.isFalse())
                .where(productCategoryJPAEntity.title.eq(categoryName))
                .where(productJPAEntity.salePrice.eq(maxPrice))
                .fetch();
    }

    @Override
    public List<ProductJPAEntity> findMinPriceProductsByCategoryName(String categoryName) {

        Double minPrice = queryFactory.select(productJPAEntity.salePrice.min())
                .from(productJPAEntity)
                .join(productJPAEntity.category, productCategoryJPAEntity)
                .where(productJPAEntity.isDel.isFalse())
                .where(productCategoryJPAEntity.title.eq(categoryName))
                .fetchOne();

        return queryFactory.selectFrom(productJPAEntity)
                .join(productJPAEntity.category, productCategoryJPAEntity)
                .join(productJPAEntity.brand, brandJPAEntity)
                .where(brandJPAEntity.isDel.isFalse())
                .where(productJPAEntity.isDel.isFalse())
                .where(productCategoryJPAEntity.title.eq(categoryName))
                .where(productJPAEntity.salePrice.eq(minPrice))
                .fetch();
    }

}

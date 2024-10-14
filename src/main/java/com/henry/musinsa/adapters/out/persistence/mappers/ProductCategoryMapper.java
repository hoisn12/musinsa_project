package com.henry.musinsa.adapters.out.persistence.mappers;

import com.henry.musinsa.adapters.out.persistence.entity.ProductCategoryJPAEntity;
import com.henry.musinsa.domain.ProductCategory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ProductCategoryMapper {
    ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);

    ProductCategory toDomain(ProductCategoryJPAEntity productCategoryJPAEntity);
    List<ProductCategory> toDomain(List<ProductCategoryJPAEntity> productCategoryJPAEntityList);

    ProductCategoryJPAEntity toEntity(ProductCategory productCategory);
    List<ProductCategoryJPAEntity> toEntity(List<ProductCategory> productCategoryList);


}

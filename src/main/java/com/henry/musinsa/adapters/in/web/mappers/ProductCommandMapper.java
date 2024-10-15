package com.henry.musinsa.adapters.in.web.mappers;


import com.henry.musinsa.application.dto.ProductCreateResponseDTO;
import com.henry.musinsa.application.dto.ProductUpdateResponseDTO;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.domain.ProductCategory;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ProductCommandMapper {
    ProductCommandMapper INSTANCE = Mappers.getMapper(ProductCommandMapper.class);

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "title", source = "product.title")
    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "brandTitle", source = "brand.title")
    @Mapping(target = "categoryId", source = "productCategory.id")
    @Mapping(target = "categoryTitle", source = "productCategory.title")
    ProductCreateResponseDTO toCreateResponse(Product product, Brand brand, ProductCategory productCategory);

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "title", source = "product.title")
    @Mapping(target = "brandId", source = "brand.id")
    @Mapping(target = "brandTitle", source = "brand.title")
    @Mapping(target = "categoryId", source = "productCategory.id")
    @Mapping(target = "categoryTitle", source = "productCategory.title")
    ProductUpdateResponseDTO toUpdateResponse(Product product, Brand brand, ProductCategory productCategory);

}

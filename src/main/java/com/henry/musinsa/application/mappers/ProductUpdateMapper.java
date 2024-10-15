package com.henry.musinsa.application.mappers;

import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.application.dto.ProductUpdateDTO;
import com.henry.musinsa.domain.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ProductUpdateMapper {
    ProductUpdateMapper INSTANCE = Mappers.getMapper(ProductUpdateMapper.class);

    Product toDomain(ProductCreateDTO productCreateDTO);

    List<Product> toDomain(List<ProductCreateDTO> productCreateDTOList);

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "title", source = "updateDTO.title")
    @Mapping(target = "price", source = "updateDTO.price")
    @Mapping(target = "salePrice", source = "updateDTO.salePrice")
    @Mapping(target = "brand", source = "updateDTO.brand")
    @Mapping(target = "category", source = "updateDTO.category")
    Product toUpdateDomain(Product product, ProductUpdateDTO updateDTO );

}

package com.henry.musinsa.application.mappers;

import com.henry.musinsa.adapters.out.persistence.mappers.BrandMapper;
import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.domain.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ProductCreateMapper {
    ProductCreateMapper INSTANCE = Mappers.getMapper(ProductCreateMapper.class);

    Product toDomain(ProductCreateDTO productCreateDTO);

    List<Product> toDomain(List<ProductCreateDTO> productCreateDTOList);

}

package com.henry.musinsa.adapters.out.persistence.mappers;

import com.henry.musinsa.adapters.out.persistence.ProductJPAEntity;
import com.henry.musinsa.domain.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toDomain(ProductJPAEntity productJPAEntity);

    ProductJPAEntity toEntity(Product product);


}

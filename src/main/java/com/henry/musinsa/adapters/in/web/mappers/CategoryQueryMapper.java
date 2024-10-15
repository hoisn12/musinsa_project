package com.henry.musinsa.adapters.in.web.mappers;


import com.henry.musinsa.application.dto.CategoryResponseDTO;
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
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder,
        imports = {LocalDateTime.class, DateTimeFormatter.class})
public interface CategoryQueryMapper {
    CategoryQueryMapper INSTANCE = Mappers.getMapper(CategoryQueryMapper.class);

    List<CategoryResponseDTO> toUpdateResponse(List<ProductCategory> productCategory);

}

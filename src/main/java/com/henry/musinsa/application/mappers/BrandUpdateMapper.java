package com.henry.musinsa.application.mappers;

import com.henry.musinsa.application.dto.BrandUpdateDTO;
import com.henry.musinsa.application.dto.ProductCreateDTO;
import com.henry.musinsa.application.dto.ProductUpdateDTO;
import com.henry.musinsa.domain.Brand;
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
public interface BrandUpdateMapper {
    BrandUpdateMapper INSTANCE = Mappers.getMapper(BrandUpdateMapper.class);

    @Mapping(target = "id", source = "brand.id")
    @Mapping(target = "title", source = "updateDTO.title")
    @Mapping(target = "description", source = "updateDTO.description")
    @Mapping(target = "joinDate", source = "brand.joinDate")
    @Mapping(target = "endDate", source = "brand.endDate")
    @Mapping(target = "isLocalDelivery", source = "updateDTO.isLocalDelivery")
    @Mapping(target = "isPrivateBrand", source = "updateDTO.isPrivateBrand")
    Brand toUpdateDomain(Brand brand, BrandUpdateDTO updateDTO );

}

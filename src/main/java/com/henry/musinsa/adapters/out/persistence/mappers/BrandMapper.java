package com.henry.musinsa.adapters.out.persistence.mappers;

import com.henry.musinsa.adapters.out.persistence.entity.BrandJPAEntity;
import com.henry.musinsa.domain.Brand;
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
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    Brand toDomain(BrandJPAEntity brandJPAEntity);
    List<Brand> toDomain(List<BrandJPAEntity> brandJPAEntityList);

    BrandJPAEntity toEntity(Brand brand);
    List<BrandJPAEntity> toEntity(List<Brand> brandList);

}

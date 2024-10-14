package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.entity.BrandJPAEntity;
import com.henry.musinsa.adapters.out.persistence.mappers.BrandMapper;
import com.henry.musinsa.adapters.out.persistence.repository.BrandJpaRepository;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.ports.out.BrandRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryAdapter implements BrandRepositoryPort {

    private final BrandJpaRepository brandJpaRepository;
    private final BrandMapper brandMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Brand> findAll() {
        return brandJpaRepository.findAll().stream().map(brandMapper::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Brand> findById(String id) {
        Optional<BrandJPAEntity> productJPAEntity = brandJpaRepository.findById(id);
        return productJPAEntity.map(brandMapper::toDomain);
    }

    @Override
    public Brand save(Brand productCategory) {
        BrandJPAEntity productCategoryJPAEntity = brandMapper.toEntity(productCategory);
        BrandJPAEntity savedEntity = brandJpaRepository.save(productCategoryJPAEntity);
        return brandMapper.toDomain(savedEntity);
    }

    @Override
    public List<Brand> saveAll(List<Brand> brandList) {
        List<BrandJPAEntity> brandJPAEntityList = brandMapper.toEntity(brandList);
        List<BrandJPAEntity> savedEntityList = brandJpaRepository.saveAll(brandJPAEntityList);
        return brandMapper.toDomain(savedEntityList);
    }

}

package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.entity.ProductCategoryJPAEntity;
import com.henry.musinsa.adapters.out.persistence.mappers.ProductCategoryMapper;
import com.henry.musinsa.adapters.out.persistence.repository.ProductCategoryJpaRepository;
import com.henry.musinsa.domain.ProductCategory;
import com.henry.musinsa.ports.out.ProductCategoryRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ProductCategoryRepositoryAdapter implements ProductCategoryRepositoryPort {

    private final ProductCategoryJpaRepository productCategoryJpaRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductCategory> findAll() {
        return productCategoryJpaRepository.findAll().stream().map(productCategoryMapper::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductCategory> findById(String id) {
        Optional<ProductCategoryJPAEntity> productCategoryJPAEntity = productCategoryJpaRepository.findById(id);
        return productCategoryJPAEntity.map(productCategoryMapper::toDomain);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategoryJPAEntity productCategoryJPAEntity = productCategoryMapper.toEntity(productCategory);
        ProductCategoryJPAEntity savedEntity = productCategoryJpaRepository.save(productCategoryJPAEntity);
        return productCategoryMapper.toDomain(savedEntity);
    }

    @Override
    public List<ProductCategory> saveAll(List<ProductCategory> productCategoryList) {
        List<ProductCategoryJPAEntity> productCategoryJPAEntityList = productCategoryMapper.toEntity(productCategoryList);
        List<ProductCategoryJPAEntity> savedEntityList = productCategoryJpaRepository.saveAll(productCategoryJPAEntityList);
        productCategoryJpaRepository.flush();
        return productCategoryMapper.toDomain(savedEntityList);
    }

    @Override
    public void flush() {
        productCategoryJpaRepository.flush();
    }

    @Override
    public Optional<ProductCategory> findByTitle(String title) {
        Optional<ProductCategoryJPAEntity> productCategoryJPAEntity = productCategoryJpaRepository.findByTitle(title);
        return productCategoryJPAEntity.map(productCategoryMapper::toDomain);
    }


}

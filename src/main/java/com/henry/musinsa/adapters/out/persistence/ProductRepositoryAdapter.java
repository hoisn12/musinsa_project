package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;
import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.adapters.out.persistence.repository.ProductJpaRepository;
import com.henry.musinsa.application.record.CategoryPriceDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(productMapper::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(String id) {
        Optional<ProductJPAEntity> productJPAEntity = productJpaRepository.findById(id);
        return productJPAEntity.map(productMapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductJPAEntity productJPAEntity = productMapper.toEntity(product);
        ProductJPAEntity savedEntity = productJpaRepository.save(productJPAEntity);
        return productMapper.toDomain(savedEntity);
    }

    @Override
    public List<Product> saveAll(List<Product> productList) {
        List<ProductJPAEntity> productJPAEntityList = productMapper.toEntity(productList);
        List<ProductJPAEntity> savedEntityList = productJpaRepository.saveAll(productJPAEntityList);

        return productMapper.toDomain(savedEntityList);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryPriceSummaryDTO findLowestPriceByCategoryAndBrand() {
        List<CategoryPriceDTO> categoryPriceDTOList = productJpaRepository.findLowestPriceByCategoryAndBrand();
        Double sumPrice = categoryPriceDTOList.stream().mapToDouble(CategoryPriceDTO::price).sum();

        return CategoryPriceSummaryDTO.builder().categoryPriceDTOList(categoryPriceDTOList).sumPrice(sumPrice).build();
    }
}

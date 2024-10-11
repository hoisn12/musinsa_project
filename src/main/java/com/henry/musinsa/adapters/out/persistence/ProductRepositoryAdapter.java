package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.adapters.out.persistence.repository.ProductJpaRepository;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.out.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productJpaRepository.findAll().stream().map(productMapper::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        Optional<ProductJPAEntity> productJPAEntity = productJpaRepository.findById(id);
        return productJPAEntity.map(productMapper::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductJPAEntity productJPAEntity = productMapper.toEntity(product);
        ProductJPAEntity savedEntity = productJpaRepository.save(productJPAEntity);
        return productMapper.toDomain(savedEntity);
    }
}

package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.entity.ProductJPAEntity;
import com.henry.musinsa.adapters.out.persistence.mappers.ProductMapper;
import com.henry.musinsa.adapters.out.persistence.repository.ProductJpaRepository;
import com.henry.musinsa.application.dto.BrandSumPriceDTO;
import com.henry.musinsa.application.dto.CategoryPriceDTO;
import com.henry.musinsa.application.dto.CategoryPriceSummaryDTO;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
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
        productJpaRepository.flush();
        return productMapper.toDomain(savedEntityList);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryPriceSummaryDTO findLowestPriceByCategoryAndBrand() {
        List<CategoryPriceDTO> categoryPriceDTOList = productJpaRepository.findLowestPriceByCategoryAndBrand();
        Double sumPrice = categoryPriceDTOList.stream().mapToDouble(CategoryPriceDTO::price).sum();

        return CategoryPriceSummaryDTO.builder().categoryPriceList(categoryPriceDTOList).sumPrice(sumPrice).build();
    }

    @Override
    @Transactional(readOnly = true)
    public BrandSumPriceDTO findBrandWithLowestTotalPrice() {
        return productJpaRepository.findBrandWithLowestTotalPrice();
    }

    @Override
    public List<Product> findLowestPriceForAllCategoriesByBrand(String brandId) {
        List<ProductJPAEntity> productJPAEntityList = productJpaRepository.findLowestPriceForAllCategoriesByBrand(brandId);

        return productMapper.toDomain(productJPAEntityList);
    }

    public Optional<Product> findActiveProductById(String id) {
        try {
            ProductJPAEntity productJPAEntity = productJpaRepository.findByIdAndIsDel(id, false);
            return Optional.ofNullable(productMapper.toDomain(productJPAEntity));
        } catch (Exception e) {
            log.error("findActiveBrandById error", e);
            throw e;
        }
    }

    @Override
    public void flush() {
        productJpaRepository.flush();
    }

    @Override
    public List<Product> findMinPriceProductsByCategoryName(String categoryName) {
        List<ProductJPAEntity> minPriceProduct = productJpaRepository.findMinPriceProductsByCategoryName(categoryName);
        return productMapper.toDomain(minPriceProduct);
    }

    @Override
    public List<Product> findMaxPriceProductsByCategoryName(String categoryName) {
        List<ProductJPAEntity> maxPriceProduct = productJpaRepository.findMaxPriceProductsByCategoryName(categoryName);
        return productMapper.toDomain(maxPriceProduct);
    }

}

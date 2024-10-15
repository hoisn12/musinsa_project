package com.henry.musinsa.ports.out;

import com.henry.musinsa.domain.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepositoryPort {
    List<Brand> findAll();
    Optional<Brand> findById(String id);
    Brand save(Brand brand);
    List<Brand> saveAll(List<Brand> brands);
    void flush();
    Optional<Brand> findActiveBrandById(String id);
}

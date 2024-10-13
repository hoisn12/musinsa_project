package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Brand;

public interface BarndQueryUseCase {
    Brand createBrand(String title, String description);
    Brand getBrand(Long brandId);
    void updateBrand(Long brandId);
    void deleteBrand(Long brandId);
}

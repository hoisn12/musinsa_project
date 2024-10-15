package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.record.BrandCreateDTO;
import com.henry.musinsa.application.record.BrandUpdateDTO;
import com.henry.musinsa.domain.Brand;

public interface BrandCommandUseCase {
    Brand createBrand(BrandCreateDTO brandCreateDTO);
    Brand updateBrand(BrandUpdateDTO brandUpdateDTO);
    void deleteBrand(String brandId);
}

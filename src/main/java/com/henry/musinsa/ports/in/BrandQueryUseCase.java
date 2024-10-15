package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Brand;

public interface BrandQueryUseCase {
    Brand getBrand(String id);
}

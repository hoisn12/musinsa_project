package com.henry.musinsa.ports.in;

import com.henry.musinsa.domain.Brand;

public interface BrandQueryUseCase {

    /**
     * 브랜드 조회
     * @param id 브랜드 id
     * @return Brand 도메인
     */
    Brand getBrand(String id);
}

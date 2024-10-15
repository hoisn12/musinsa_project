package com.henry.musinsa.ports.in;

import com.henry.musinsa.application.dto.BrandCreateDTO;
import com.henry.musinsa.application.dto.BrandUpdateDTO;
import com.henry.musinsa.domain.Brand;

public interface BrandCommandUseCase {

    /**
     * 브랜드 생성
     * @param brandCreateDTO 데이터
     * @return Brand 도메인
     */
    Brand createBrand(BrandCreateDTO brandCreateDTO);

    /**
     * 브랜드 수정
     * @param brandUpdateDTO 데이터
     * @return Brand 도메인
     */
    Brand updateBrand(BrandUpdateDTO brandUpdateDTO);

    /**
     * 브랜드 삭제
     * @param brandId brand id
     */
    void deleteBrand(String brandId);
}

package com.henry.musinsa.application;

import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.ports.in.BrandQueryUseCase;
import com.henry.musinsa.ports.out.BrandRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandQueryService implements BrandQueryUseCase {

    private final BrandRepositoryPort brandRepository;

    @Override
    public Brand getBrand(String id) throws ApplicationException{
        return brandRepository.findActiveBrandById(id).orElseThrow(() -> new ApplicationException(ErrorCode.BRAND_NOT_FOUND));
    }

}

package com.henry.musinsa.application;

import com.henry.musinsa.application.record.BrandSumPriceDTO;
import com.henry.musinsa.application.record.BrandSumPriceSummaryDTO;
import com.henry.musinsa.application.record.CategoryPriceDTO;
import com.henry.musinsa.application.record.CategoryPriceSummaryDTO;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.domain.Product;
import com.henry.musinsa.ports.in.BrandQueryUseCase;
import com.henry.musinsa.ports.in.ProductQueryUseCase;
import com.henry.musinsa.ports.out.BrandRepositoryPort;
import com.henry.musinsa.ports.out.ProductRepositoryPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandQueryService implements BrandQueryUseCase {

    private final BrandRepositoryPort brandRepository;

    @Override
    public Brand getBrand(String id) {
        return brandRepository.findById(id).orElseThrow(() -> new ApplicationException(ErrorCode.BRAND_NOT_FOUND));
    }

}

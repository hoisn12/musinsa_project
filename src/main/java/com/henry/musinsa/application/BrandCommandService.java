package com.henry.musinsa.application;

import com.henry.musinsa.application.record.BrandCreateDTO;
import com.henry.musinsa.application.record.BrandUpdateDTO;
import com.henry.musinsa.common.ErrorCode;
import com.henry.musinsa.common.StringCustomUtils;
import com.henry.musinsa.common.exception.ApplicationException;
import com.henry.musinsa.domain.Brand;
import com.henry.musinsa.ports.in.BrandCommandUseCase;
import com.henry.musinsa.ports.out.BrandRepositoryPort;
import java.text.ParseException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandCommandService implements BrandCommandUseCase {

    private final BrandRepositoryPort brandRepository;

    @Override
    public Brand createBrand(BrandCreateDTO brandCreateDTO) {
        if(null == brandCreateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_BRAND_DATA_EMPTY);
        }

        try {
            LocalDate joinDate = StringCustomUtils.getLocalDateForgetFormatter(brandCreateDTO.joinDate());

            Brand createBrand = Brand.builder()
                    .title(brandCreateDTO.title())
                    .joinDate(joinDate)
                    .isPrivateBrand(brandCreateDTO.isPrivateBrand())
                    .isLocalDelivery(brandCreateDTO.isLocalDelivery()).build();
            return brandRepository.save(createBrand);
        } catch (ParseException e) {
            throw new ApplicationException(ErrorCode.DATE_FORMAT_MISMATCH);
        }
    }

    @Override
    public Brand updateBrand(BrandUpdateDTO brandUpdateDTO) {
        if(null == brandUpdateDTO) {
            throw new ApplicationException(ErrorCode.CREATE_BRAND_DATA_EMPTY);
        }

        brandRepository.findActiveBrandById(brandUpdateDTO.id()).orElseThrow(() -> new ApplicationException(ErrorCode.BRAND_NOT_FOUND));

        try {
            LocalDate joinDate = StringCustomUtils.getLocalDateForgetFormatter(brandUpdateDTO.joinDate());

            Brand createBrand = Brand.builder()
                    .id(brandUpdateDTO.id())
                    .title(brandUpdateDTO.title())
                    .joinDate(joinDate)
                    .isPrivateBrand(brandUpdateDTO.isPrivateBrand())
                    .isLocalDelivery(brandUpdateDTO.isLocalDelivery()).build();
            return brandRepository.save(createBrand);
        } catch (ParseException e) {
            throw new ApplicationException(ErrorCode.DATE_FORMAT_MISMATCH);
        }
    }

    public void deleteBrand(String brandId) {
        Brand brand = brandRepository.findActiveBrandById(brandId).orElseThrow(() -> new ApplicationException(ErrorCode.BRAND_NOT_FOUND));
        brand.delete();
        brandRepository.save(brand);
    }
}

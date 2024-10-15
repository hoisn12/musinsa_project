package com.henry.musinsa.application.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.ObjectUtils;

@Data
public class BrandUpdateDTO {

        @NotBlank(message = "ID는 필수입니다.")
        private String id;
        @NotBlank(message = "브랜드명은 필수입니다.")
        private String title;
        private String description;
        @NotBlank(message = "날짜는 필수입니다.")
        @Pattern(regexp = "\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", message = "날짜형식(yyyyMMdd)이 일치해야 합니다.")
        private String joinDate;
        private Boolean isLocalDelivery = false;
        private Boolean isPrivateBrand = true;
}

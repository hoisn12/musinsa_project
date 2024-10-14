package com.henry.musinsa.adapters.out.persistence.repository.custom;

import com.henry.musinsa.adapters.out.persistence.entity.UserJPAEntity;
import java.util.Optional;


public interface UserJpaRepositoryCustom {
    Optional<UserJPAEntity> findAdmin();
}

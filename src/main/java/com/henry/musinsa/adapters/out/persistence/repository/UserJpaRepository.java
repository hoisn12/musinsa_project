package com.henry.musinsa.adapters.out.persistence.repository;

import com.henry.musinsa.adapters.out.persistence.entity.UserJPAEntity;
import com.henry.musinsa.adapters.out.persistence.repository.custom.UserJpaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserJPAEntity, Long>, UserJpaRepositoryCustom {

}

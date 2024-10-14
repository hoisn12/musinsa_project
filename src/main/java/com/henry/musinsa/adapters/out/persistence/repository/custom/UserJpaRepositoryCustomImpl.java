package com.henry.musinsa.adapters.out.persistence.repository.custom;


import static com.henry.musinsa.adapters.out.persistence.entity.QUserJPAEntity.userJPAEntity;

import com.henry.musinsa.adapters.out.persistence.entity.UserJPAEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryCustomImpl implements UserJpaRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<UserJPAEntity> findAdmin() {
        return Optional.ofNullable(
                queryFactory.selectFrom(userJPAEntity)
                        .where(userJPAEntity.isAdmin.isTrue())
                        .where(userJPAEntity.isDel.isFalse())
                        .fetchOne()
        );
    }
}

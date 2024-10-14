package com.henry.musinsa.adapters.out.persistence;

import com.henry.musinsa.adapters.out.persistence.entity.UserJPAEntity;
import com.henry.musinsa.adapters.out.persistence.mappers.UserMapper;
import com.henry.musinsa.adapters.out.persistence.repository.UserJpaRepository;
import com.henry.musinsa.domain.User;
import com.henry.musinsa.ports.out.UserRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userJpaRepository.findAll().stream().map(userMapper::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        Optional<UserJPAEntity> productJPAEntity = userJpaRepository.findById(id);
        return productJPAEntity.map(userMapper::toDomain);
    }

    @Override
    public User save(User user) {
        UserJPAEntity userJPAEntity = userMapper.toEntity(user);
        UserJPAEntity savedEntity = userJpaRepository.save(userJPAEntity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    public List<User> saveAll(List<User> userList) {
        List<UserJPAEntity> userJPAEntityList = userMapper.toEntity(userList);
        List<UserJPAEntity> savedEntityList = userJpaRepository.saveAll(userJPAEntityList);

        return userMapper.toDomain(savedEntityList);
    }

    @Override
    public Optional<User> findAdmin() {
        Optional<UserJPAEntity> userOptional = userJpaRepository.findAdmin();
        return userOptional.map(userMapper::toDomain);
    }

}

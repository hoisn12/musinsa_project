package com.henry.musinsa.ports.out;

import com.henry.musinsa.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findAdmin();
    User save(User user);
    List<User> saveAll(List<User> userList);
    void flush();
}

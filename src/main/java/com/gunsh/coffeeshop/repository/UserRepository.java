package com.gunsh.coffeeshop.repository;

import java.util.List;
import java.util.Optional;

import com.gunsh.coffeeshop.model.CustomUser;

public interface UserRepository {
    List<CustomUser> findAll();
    Optional<CustomUser> findByUsername(String username);
    void save(CustomUser user);
}

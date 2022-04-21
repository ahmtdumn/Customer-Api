package com.duman.customer.service;

import com.duman.customer.model.entity.User;

import java.util.Optional;


public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}

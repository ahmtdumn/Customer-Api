package com.duman.customer.service.impl;


import com.duman.customer.model.entity.User;
import com.duman.customer.model.enumerated.Role;
import com.duman.customer.repository.UserRepository;
import com.duman.customer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDate.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    @Transactional //TransactionalRequired when executing an update/delete query.
    public void makeAdmin(String username) {
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}

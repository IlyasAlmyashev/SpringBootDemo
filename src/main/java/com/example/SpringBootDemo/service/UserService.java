package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteById(Long id);

    User findById(Long id);

    List<User> findAll();
}

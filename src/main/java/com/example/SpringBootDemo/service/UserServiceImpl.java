package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.repository.UserRepository;
import com.example.SpringBootDemo.security.PasswordConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordConfig passwordConfig;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordConfig passwordConfig) {
        this.userRepository = userRepository;
        this.passwordConfig = passwordConfig;
    }

    @Override
    public void saveUser(User user) {
        if (userRepository.getUserByUsername(user.getUsername()) == null) {
            user.setPassword(passwordConfig.getPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        String oldPassword = user.getPassword();
        try {
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(oldPassword);
            } else {
                passwordConfig.getPasswordEncoder().encode(user.getPassword());
            }
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            user.setPassword(oldPassword);
        }
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }
}

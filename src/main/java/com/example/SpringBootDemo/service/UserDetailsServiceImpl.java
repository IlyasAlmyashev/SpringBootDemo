//package com.example.SpringBootDemo.service;
//
//import com.example.SpringBootDemo.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.getUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found: " + username);
//        }
//        return user;
//    }
//}

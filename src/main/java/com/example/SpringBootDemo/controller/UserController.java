package com.example.SpringBootDemo.controller;

import com.example.SpringBootDemo.model.User;
import com.example.SpringBootDemo.service.RoleService;
import com.example.SpringBootDemo.service.UserService;
import com.example.SpringBootDemo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserServiceImpl userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userInfo(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user-page";
    }
}

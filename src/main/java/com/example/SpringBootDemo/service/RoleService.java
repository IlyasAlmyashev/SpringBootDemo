package com.example.SpringBootDemo.service;

import com.example.SpringBootDemo.model.Role;

import java.util.List;

public interface RoleService {

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteById(Long id);

    Role findById(Long id);

    List<Role> findAll();

    Role getRoleByName(String roleName);
}

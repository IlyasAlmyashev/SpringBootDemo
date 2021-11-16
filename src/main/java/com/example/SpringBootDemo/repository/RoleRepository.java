package com.example.SpringBootDemo.repository;

import com.example.SpringBootDemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByRoleName(String roleName);
}
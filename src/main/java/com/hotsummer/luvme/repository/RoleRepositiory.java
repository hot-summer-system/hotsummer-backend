package com.hotsummer.luvme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotsummer.luvme.model.entity.Role;

public interface RoleRepositiory extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}

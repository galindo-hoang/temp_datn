package com.example.UserService.repository;

import com.example.UserService.model.entity.RoleEntity;
import com.example.UserService.utils.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findRoleByRoleName(UserRole name);
}

package com.example.UserService.service;

import com.example.UserService.model.entity.RoleEntity;
import com.example.UserService.model.entity.UserEntity;
import com.example.UserService.utils.UserRole;

import java.util.List;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);
    RoleEntity saveRole(RoleEntity roleEntity);
    void addRoleToUser(String phoneNumber, UserRole roleName);
    UserEntity getUserByPhoneNumber(String phoneNumber);
    UserEntity getUserById(Long id);
    List<UserEntity> getUsers();
}

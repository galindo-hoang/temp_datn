package com.example.UserService.repository;

import com.example.UserService.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserById(Long id);
    UserEntity findUserByPhoneNumber(String phoneNumber);
}

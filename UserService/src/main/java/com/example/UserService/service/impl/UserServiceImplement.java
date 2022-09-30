package com.example.UserService.service.impl;

import com.example.UserService.model.entity.RoleEntity;
import com.example.UserService.model.entity.UserEntity;
import com.example.UserService.repository.RoleRepository;
import com.example.UserService.repository.UserRepository;
import com.example.UserService.service.UserService;
import com.example.UserService.utils.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplement implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    // ?
    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByPhoneNumber(phoneNumber);
        if(userEntity == null) {
            log.info("User not found in database");
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userEntity.getRoleEntity().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString())));
        return new org.springframework.security.core.userdetails.User(userEntity.getPhoneNumber(), userEntity.getPassword(), authorities);
    }
    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        log.info("Saving new user {} to database", userEntity);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public RoleEntity saveRole(RoleEntity roleEntity) {
        log.info("Saving new role {} to database", roleEntity);
        return roleRepository.save(roleEntity);
    }

    @Override
    public void addRoleToUser(String phoneNumber, UserRole roleName) {
        log.info("Adding role {} to user having phone number {}", roleName, phoneNumber);
        UserEntity userEntity = userRepository.findUserByPhoneNumber(phoneNumber);
        RoleEntity roleEntity = roleRepository.findRoleByRoleName(roleName);
        userEntity.getRoleEntity().add(roleEntity);
    }

    @Override
    public UserEntity getUserByPhoneNumber(String phoneNumber) {
        log.info("Fetching user having phone number {}", phoneNumber);
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public UserEntity getUserById(Long id) {
        log.info("Fetching user having id{}", id);
        return userRepository.findUserById(id);
    }

    @Override
    public List<UserEntity> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }
}

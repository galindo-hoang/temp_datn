package com.example.UserService.controller;

//import com.example.Loginservice.mapper.UserMapper;

import com.example.UserService.mapper.UserMapper;
import com.example.UserService.model.dto.UserDto;
import com.example.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/user")
public class UserController  {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers().stream().map(userMapper::entityToDto).toList());
    }

}

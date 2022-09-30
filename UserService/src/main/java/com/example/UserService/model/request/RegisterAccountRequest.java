package com.example.UserService.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterAccountRequest {
    private String phoneNumber;
    private String password;
    private String userName;
    private byte[] fileImage;
    private Date birthday;
}

package com.example.UserService.utils;

import java.util.Date;

public class Constants {
    public static final Date expired_time_access_token = new Date(System.currentTimeMillis() + 10 * 60 * 1000); // 10 minus
    public static final Date expired_time_refresh_token = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000); // 24 hours
    public static final byte[] key_array_byte_encode_jwt = "secret".getBytes();
}

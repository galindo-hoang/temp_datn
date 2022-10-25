package com.example.productservice.exception;

import com.example.productservice.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException() {
        super("Resource Not Found");
    }
    public ResourceNotFoundException(String e) {
        super(e);
    }
}

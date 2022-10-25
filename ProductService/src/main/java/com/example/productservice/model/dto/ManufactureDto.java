package com.example.productservice.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManufactureDto {
    private Long id;
    private String name;
    private String phoneNumber;
}

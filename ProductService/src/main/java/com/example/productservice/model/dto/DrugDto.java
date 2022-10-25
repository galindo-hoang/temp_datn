package com.example.productservice.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class DrugDto {
    private Long id;
    private String drugName;
    private byte[] image;
    private String dosageForm;
    private String indication;
    private String contraIndication;
    private String sideEffect;
    private String expiredDate;
    private String manufacture;

    private List<CategoryDto> categories = new ArrayList<>();
    private List<IngredientDto> ingredients = new ArrayList<>();
}

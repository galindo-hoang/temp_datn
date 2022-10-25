package com.example.productservice.mapper.decorator;

import com.example.productservice.mapper.DrugMapper;
import com.example.productservice.model.dto.DrugDto;
import com.example.productservice.model.dto.IngredientDto;
import com.example.productservice.model.entity.DrugEntity;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DrugMapperDecorator implements DrugMapper {
    @Autowired
    private DrugMapper delegate;

    @Override
    public DrugDto entityToDto(DrugEntity drugEntity) {
        DrugDto drugDto = delegate.entityToDto(drugEntity);
        drugDto.getIngredients().addAll(
                drugEntity.getIngredients()
                        .stream()
                        .map(entity -> new IngredientDto(
                                entity.getId().getIngredientId(),
                                entity.getIngredient().getName(),
                                entity.getUnit(),entity.getNumberUnit()))
                        .toList());
        return drugDto;
    }
}

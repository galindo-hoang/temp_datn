package com.example.productservice.mapper;

import com.example.productservice.mapper.decorator.DrugMapperDecorator;
import com.example.productservice.model.dto.DrugDto;
import com.example.productservice.model.entity.DrugEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@DecoratedWith(DrugMapperDecorator.class)
public interface DrugMapper {
    @Mapping(target = "ingredients", ignore = true)
    DrugDto entityToDto(DrugEntity drugEntity);
    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "ingredients", ignore = true)
    DrugEntity dtoToEntity(DrugDto drugDto);
}

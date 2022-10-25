package com.example.productservice.service.impl;

import com.example.productservice.exception.ResourceNotFoundException;
import com.example.productservice.mapper.DrugMapper;
import com.example.productservice.model.dto.CategoryDto;
import com.example.productservice.model.dto.DrugDto;
import com.example.productservice.model.dto.IngredientDto;
import com.example.productservice.model.entity.CategoryEntity;
import com.example.productservice.model.entity.DrugEntity;
import com.example.productservice.model.entity.IngredientEntity;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.DrugRepository;
import com.example.productservice.repository.IngredientRepository;
import com.example.productservice.service.DrugService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final DrugMapper drugMapper;

    @Override
    public List<DrugEntity> findDrugsByCategory(String cateName) {
        CategoryEntity categoryEntities = categoryRepository
                .findCategoryEntityByName(cateName)
                .orElseThrow(() -> new ResourceNotFoundException("name of category not found"));
        return drugRepository.findDrugsByCategory(categoryEntities.getId());
    }

    @Override
    public DrugEntity findDrugById(Long id) {
        return drugRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drug not found"));
    }

    @Override
    public List<DrugEntity> findAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public DrugEntity save(DrugDto drugDto) {
        DrugEntity drugEntity = drugMapper.dtoToEntity(drugDto);
        List<IngredientEntity> ingredientEntities = ingredientRepository.findIngredientEntitiesByIdIn(
                drugDto.getCategories()
                        .stream()
                        .map(CategoryDto::getId).toList()
        );
        List<CategoryEntity> categories = categoryRepository.findCategoryEntityByIdIn(
                drugDto.getCategories()
                        .stream()
                        .map(CategoryDto::getId).toList()
        );

        ingredientEntities.forEach( ingredient -> {
            IngredientDto ingredientDto = (IngredientDto) drugDto
                    .getIngredients()
                    .stream()
                    .filter(dto -> dto.getName().equals(ingredient.getName()));
            drugEntity.addIngredient(ingredient, ingredientDto.getUnit(), ingredientDto.getNumberUnit());
        });
        drugEntity.getCategories().addAll(categories);
        return drugRepository.save(drugEntity);
    }

    @Override
    public void delete(Long id) {
        try {
            drugRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Drug not found");
        }
    }
}

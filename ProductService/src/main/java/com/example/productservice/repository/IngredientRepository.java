package com.example.productservice.repository;

import com.example.productservice.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    List<IngredientEntity> findIngredientEntitiesByIdIn(List<Long> id);
}

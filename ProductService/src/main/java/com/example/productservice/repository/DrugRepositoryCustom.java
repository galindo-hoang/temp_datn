package com.example.productservice.repository;

import com.example.productservice.model.entity.DrugEntity;

import java.util.List;

public interface DrugRepositoryCustom {
    List<DrugEntity> findDrugsByCategory(Long id);
}

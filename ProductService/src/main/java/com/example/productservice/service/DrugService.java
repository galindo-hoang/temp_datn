package com.example.productservice.service;

import com.example.productservice.model.dto.DrugDto;
import com.example.productservice.model.entity.DrugEntity;

import java.util.List;

public interface DrugService {
    List<DrugEntity> findDrugsByCategory(String cateName);
    DrugEntity findDrugById(Long id);
    List<DrugEntity> findAllDrugs();
    DrugEntity save(DrugDto drugDto);
    void delete(Long id);
}

package com.example.productservice.common.model;

import com.example.productservice.model.entity.QCategoryEntity;
import com.example.productservice.model.entity.QDrugEntity;
import com.example.productservice.model.entity.QIngredientEntity;

public class QueryEntity {

    public static final QDrugEntity qDrug = QDrugEntity.drugEntity;
    public static final QCategoryEntity qCategory = QCategoryEntity.categoryEntity;
    public static final QIngredientEntity qIngredient = QIngredientEntity.ingredientEntity;
}

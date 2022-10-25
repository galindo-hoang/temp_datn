package com.example.productservice.repository.impl;

import com.example.productservice.model.entity.DrugEntity;
import com.example.productservice.repository.DrugRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.example.productservice.common.model.QueryEntity.qCategory;
import static com.example.productservice.common.model.QueryEntity.qDrug;

public class DrugRepositoryCustomImpl implements DrugRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DrugEntity> findDrugsByCategory(Long id) {
        JPAQuery<DrugEntity> query = new JPAQuery<DrugEntity>(entityManager)
                .from(qDrug)
                .innerJoin(qDrug.categories,qCategory);
        return query.fetch();
    }
}

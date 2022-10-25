package com.example.productservice.repository;

import com.example.productservice.model.entity.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<DrugEntity, Long>, DrugRepositoryCustom {

}

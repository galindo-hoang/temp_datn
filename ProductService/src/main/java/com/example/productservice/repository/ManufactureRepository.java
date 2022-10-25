package com.example.productservice.repository;

import com.example.productservice.model.entity.ManufactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<ManufactureEntity, Long> {
}

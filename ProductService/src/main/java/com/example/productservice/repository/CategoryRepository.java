package com.example.productservice.repository;

import com.example.productservice.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findCategoryEntityByName(String name);
    List<CategoryEntity> findCategoryEntityByIdIn(List<Long> ids);
}

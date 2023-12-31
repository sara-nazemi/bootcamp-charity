package com.example.bootcampcharity.repositories;

import com.example.bootcampcharity.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
}

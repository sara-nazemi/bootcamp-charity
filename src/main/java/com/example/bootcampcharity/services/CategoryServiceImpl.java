package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.entities.CategoryEntity;
import com.example.bootcampcharity.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity,Long> implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    protected JpaRepository<CategoryEntity, Long> getRepository() {
        return categoryRepository;
    }
}

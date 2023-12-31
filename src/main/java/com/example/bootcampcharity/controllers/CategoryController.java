package com.example.bootcampcharity.controllers;

import com.example.bootcampcharity.models.dtoes.CategoryDto;
import com.example.bootcampcharity.models.entities.CategoryEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Transactional(readOnly = true)
public class CategoryController extends BaseController<CategoryEntity, CategoryDto,Long>{
}

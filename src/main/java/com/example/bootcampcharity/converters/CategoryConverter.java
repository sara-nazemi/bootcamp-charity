package com.example.bootcampcharity.converters;

import com.example.bootcampcharity.models.dtoes.CategoryDto;
import com.example.bootcampcharity.models.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryConverter extends BaseConverter<CategoryEntity, CategoryDto>{

}

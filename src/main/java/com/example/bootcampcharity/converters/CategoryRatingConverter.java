package com.example.bootcampcharity.converters;

import com.example.bootcampcharity.models.dtoes.CategoryRatingDto;
import com.example.bootcampcharity.models.entities.CategoryRating;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryRatingConverter extends BaseConverter<CategoryRating, CategoryRatingDto> {

    @Mapping(source = "category", target = "category.id")
    @Mapping(source = "charity", target = "charity.id")
    @Mapping(source = "charityVersion", target = "charity.version")
    @Mapping(source = "categoryVersion", target = "category.version")
    CategoryRating convertEntity(CategoryRatingDto dto);


    @Mapping(source = "category.id", target = "category")
    @Mapping(source = "charity.id", target = "charity")
    @Mapping(source = "charity.version", target = "charityVersion")
    @Mapping(source = "category.version", target = "categoryVersion")
    CategoryRatingDto convertDto(CategoryRating rating);
}

package com.example.bootcampcharity.converters;

import com.example.bootcampcharity.models.dtoes.CharityDto;
import com.example.bootcampcharity.models.entities.CharityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharityConverter extends BaseConverter<CharityEntity, CharityDto> {
    @Override
    @Mapping(source = "categoryId",target = "category.id")
    @Mapping(source = "versionCategory",target = "category.version")
    CharityEntity convertEntity(CharityDto model);

    @Override
    @Mapping(source = "category.id",target = "categoryId")
    @Mapping(source = "category.version",target = "versionCategory")
    CharityDto convertDto(CharityEntity model);
}

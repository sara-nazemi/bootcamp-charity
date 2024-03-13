package com.example.bootcampcharity.converters;

import com.example.bootcampcharity.models.dtoes.CharityDto;
import com.example.bootcampcharity.models.entities.CharityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharityConverter extends BaseConverter<CharityEntity, CharityDto> {
}

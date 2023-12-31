package com.example.bootcampcharity.converters;

import com.example.bootcampcharity.models.dtoes.TransactionLogDto;
import com.example.bootcampcharity.models.entities.TransactionLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionLogConverter extends BaseConverter<TransactionLogEntity, TransactionLogDto> {
    @Override
    @Mapping(source = "charityId",target="charity.id")
    @Mapping(source = "versionCharity",target="charity.version")
    TransactionLogEntity convertEntity(TransactionLogDto model);

    @Override

    @Mapping(source = "charity.id",target="charityId")
    @Mapping(source = "charity.version",target="versionCharity")
    TransactionLogDto convertDto(TransactionLogEntity model);
}

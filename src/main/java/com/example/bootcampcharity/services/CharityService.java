package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.dtoes.DepositCharityInfoDto;
import com.example.bootcampcharity.models.entities.CharityEntity;

public interface CharityService extends BaseService<CharityEntity,Long>{
    Boolean charity(DepositCharityInfoDto dto);

}

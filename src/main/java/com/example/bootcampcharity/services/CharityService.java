package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.dtoes.DepositCharityInfoDto;
import com.example.bootcampcharity.models.entities.CharityEntity;

import java.util.List;

public interface CharityService extends BaseService<CharityEntity,Long>{

    CharityEntity save(CharityEntity entity);

    void deleteById(Long id);
    CharityEntity findById(Long id);

    List<CharityEntity> findAll();

    Boolean charity(DepositCharityInfoDto dto);


}

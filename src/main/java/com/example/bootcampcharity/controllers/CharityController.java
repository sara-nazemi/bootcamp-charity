package com.example.bootcampcharity.controllers;

import com.example.bootcampcharity.models.dtoes.CharityDto;
import com.example.bootcampcharity.models.dtoes.DepositCharityInfoDto;
import com.example.bootcampcharity.models.entities.CharityEntity;
import com.example.bootcampcharity.sampleRespose.CharityResponse;
import com.example.bootcampcharity.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/charity")
@Transactional(readOnly = true)
public class CharityController extends BaseController<CharityEntity, CharityDto, Long> {
    @Autowired
    CharityService charityService;

    @PostMapping
    @Transactional
    public CharityResponse<?> charity(@RequestBody DepositCharityInfoDto dto, @RequestHeader("lang") String lang) {
        Boolean charity = charityService.charity(dto);
        CharityResponse<Object> objectCharityResponse = new CharityResponse<>();
        objectCharityResponse.setData(charity);
        return objectCharityResponse;
    }


}

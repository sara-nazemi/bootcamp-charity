package com.example.bootcampcharity.controllers;

import com.example.bootcampcharity.converters.BaseConverter;
import com.example.bootcampcharity.models.valids.GeneralValidationGroup;
import com.example.bootcampcharity.models.valids.NotNullGroup;
import com.example.bootcampcharity.sampleRespose.CharityResponse;
import com.example.bootcampcharity.services.BaseService;
import com.example.bootcampcharity.util.ResourceBundleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;

public abstract class BaseController<E,D,ID> {
    @Autowired
    private BaseService<E, ID> baseService;

    @Autowired
    private BaseConverter<E, D> baseConverter;

    // because the classes that inherited from this also need this field (protected)

    @Autowired
    protected ResourceBundleUtil resourceBundleUtil;

    @PostMapping("/save")
    @Transactional
    public CharityResponse<?> save(@RequestBody D dto, @RequestHeader("lang") String lang) {
        E entity = baseConverter.convertEntity(dto);
        E save = baseService.save(entity);
        D result = baseConverter.convertDto(save);

        return CharityResponse.builder()
                .message(resourceBundleUtil.getMessage("operation.successful.run", lang))
                .code("operation.successful.run")
                .date(new Date())
                .hasError(false)
                .data(result)
                .build();

    }
}
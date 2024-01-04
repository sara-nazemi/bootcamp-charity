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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping("/findById/{id}")
    @Transactional(readOnly = true)
    public CharityResponse<?> findById(@PathVariable ID id, @RequestHeader("lang") String lang) {

        E byId = baseService.findById(id);
        D find = baseConverter.convertDto(byId);
        return CharityResponse.builder()
                .message(resourceBundleUtil.getMessage("operation.successful.run", lang))
                .code("operation.successful.run")
                .date(new Date())
                .hasError(false)
                .data(find)
                .build();
    }

    @GetMapping("/findAll")
    @Transactional(readOnly = true)
    public CharityResponse<?> findAll(@RequestHeader("lang") String lang) {
        List<E> all = baseService.findAll();
        List<D> find = baseConverter.converterDtoes(all);
        return CharityResponse.builder()
                .message(resourceBundleUtil.getMessage("users.finded.successfull", lang))
                .code("users.finded.successfull")
                .date(new Date())
                .hasError(false)
                .data(find)
                .build();
    }

    @DeleteMapping("/delete")
    @Transactional
    public CharityResponse<?> deleteById(@RequestParam ID id, @RequestHeader("lang") String lang) {
        baseService.deleteById(id);
        return CharityResponse.builder()
                .message(resourceBundleUtil.getMessage("user.delete.successfull", lang))
                .code("user.delete.successfull")
                .date(new Date())
                .hasError(false)
                .data(true)
                .build();
    }
}
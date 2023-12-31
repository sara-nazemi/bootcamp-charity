package com.example.bootcampcharity.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BaseServiceImpl<E, ID> implements BaseService<E, ID> {

    protected abstract JpaRepository<E, ID> getRepository();

    @Override
    public E save(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public E findById(ID id) {
        return getRepository().findById(id).get();
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }
}

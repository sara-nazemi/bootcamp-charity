package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.documents.ExceptionDocument;
import com.example.bootcampcharity.repositories.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService{
    private final ExceptionRepository exceptionRepository;

    @Autowired
    public ExceptionServiceImpl(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @Override
    public void saveException(ExceptionDocument exceptionDocument) {
        exceptionRepository.save(exceptionDocument);
    }
}

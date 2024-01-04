package com.example.bootcampcharity.services;

import com.example.bootcampcharity.models.entities.TransactionLogEntity;
import com.example.bootcampcharity.repositories.TransactionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigTreeConfigDataLocationResolver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionLogServiceImpl extends BaseServiceImpl<TransactionLogEntity,Long> implements TransactionLogService{

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    @Override
    protected JpaRepository<TransactionLogEntity, Long> getRepository() {
        return transactionLogRepository;
    }

    @Override
    public TransactionLogEntity findById(Long aLong) {
        return null;
    }
}

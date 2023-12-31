package com.example.bootcampcharity.repositories;

import com.example.bootcampcharity.models.entities.TransactionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionLogRepository extends JpaRepository<TransactionLogEntity, Long> {
}

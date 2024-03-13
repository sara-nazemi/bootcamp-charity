package com.example.bootcampcharity.repositories;

import com.example.bootcampcharity.models.documents.LogDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogDocument,String> {
}

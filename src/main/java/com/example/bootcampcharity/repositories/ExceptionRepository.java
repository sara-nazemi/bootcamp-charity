package com.example.bootcampcharity.repositories;

import com.example.bootcampcharity.models.documents.ExceptionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExceptionRepository extends MongoRepository<ExceptionDocument,String > {
}

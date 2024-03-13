package com.example.bootcampcharity.models.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Document("CharityLogs")
public class LogDocument {
    @MongoId
    private String id;
    private String methodName;
    private String errorTrace;
    private Object request;
    private Object response;
}

package com.example.bootcampcharity.controlleradvice.logger;

import com.example.bootcampcharity.models.documents.LogDocument;
import com.example.bootcampcharity.repositories.LogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Aspect
@Component
public class ControllerLogger {

    private static final Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ControllerLogger(LogRepository logRepository, ObjectMapper objectMapper) {
        this.logRepository = logRepository;
        this.objectMapper = objectMapper;
    }

    @Around("within(com.example.bootcampcharity.controllers.BaseController+)")
    public Object logRestControllers(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LogDocument log = new LogDocument();
        log.setMethodName(proceedingJoinPoint.getSignature().getName());
        log.setRequest(proceedingJoinPoint.getArgs());
        Object rstValue;
        try {
            rstValue = proceedingJoinPoint.proceed();
            if (rstValue != null) {
                log.setResponse(rstValue);
            }
            logRepository.save(log);
            logger.info("success request" + objectMapper.writeValueAsString(log));
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            log.setErrorTrace(writer.toString());
            logRepository.save(log);
            logger.error("fail request" + objectMapper.writeValueAsString(log));
            throw e;
        }
        return rstValue;
    }

    @Pointcut("within(com.example.bootcampcharity.services.*)")
    public void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logServiceMethods(JoinPoint joinPoint) {
        logger.info("service methods called" + joinPoint.toString());

    }
}

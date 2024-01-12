package com.example.bootcampcharity;

//import com.example.bootcampcharity.config.HeaderValidationFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories
@EnableMongoRepositories
@EntityScan
@EnableAspectJAutoProxy
@EnableAsync
@EnableCaching
@EnableFeignClients
@EnableJpaAuditing
public class BootcampCharityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampCharityApplication.class, args);
    }

}

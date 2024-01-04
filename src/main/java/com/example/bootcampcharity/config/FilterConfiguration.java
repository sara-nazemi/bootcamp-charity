package com.example.bootcampcharity.config;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    @Order(1)
    public FilterRegistrationBean<HeaderValidationFilter> headerValidationFilter() {
        FilterRegistrationBean<HeaderValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter());
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        return registrationBean;
    }

    @Bean
    public HeaderValidationFilter filter() {
        return new HeaderValidationFilter();
    }
}

package com.ibm.esw.lms.sprintboot.starter.self.config;

import com.ibm.esw.lms.sprintboot.starter.self.service.ValidationService;
import com.ibm.esw.lms.sprintboot.starter.self.service.impl.ValidationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitBeans {

    @Bean
    public ValidationService initValidateSolutionId(){
        return new ValidationServiceImpl();
    }
}

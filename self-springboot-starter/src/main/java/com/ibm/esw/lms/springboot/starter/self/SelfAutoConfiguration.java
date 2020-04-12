package com.ibm.esw.lms.springboot.starter.self;

import com.ibm.esw.lms.springboot.starter.self.config.SelfProperties;
import com.ibm.esw.lms.springboot.starter.self.service.SelfBootStarterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties(SelfProperties.class)
public class SelfAutoConfiguration {
    @Autowired
    SelfProperties selfProperties;

    private SelfBootStarterService selfBootStarterService;

    @Bean
    @ConditionalOnMissingBean(SelfBootStarterService.class)
    public SelfBootStarterService init(){
        log.info("init self springboot starter service bean");
        return new SelfBootStarterService(selfProperties);
    }

}

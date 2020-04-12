package com.ibm.esw.lms.springboot.starter.self.service;

import com.ibm.esw.lms.springboot.starter.self.config.SelfProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SelfBootStarterService {

    private SelfProperties properties;

    public SelfBootStarterService(SelfProperties properties){
        this.properties = properties;
    }

    public String printConfig(){
        log.info("self springboot start service print properties : ", properties);
        return properties.toString();
    }

}

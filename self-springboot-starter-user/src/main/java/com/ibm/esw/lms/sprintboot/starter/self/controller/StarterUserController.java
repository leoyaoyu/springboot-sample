package com.ibm.esw.lms.sprintboot.starter.self.controller;

import com.ibm.esw.lms.springboot.starter.annotation.annotation.LoggerAnnotation;
import com.ibm.esw.lms.springboot.starter.self.service.SelfBootStarterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StarterUserController {

    @Autowired
    SelfBootStarterService selfBootStarterService;

    @RequestMapping(value = "/properties", method = RequestMethod.GET)
    @LoggerAnnotation
    public String getProperties(){
        String result = selfBootStarterService.printConfig();
        log.info("result : {}", result);
        return result;
    }
}

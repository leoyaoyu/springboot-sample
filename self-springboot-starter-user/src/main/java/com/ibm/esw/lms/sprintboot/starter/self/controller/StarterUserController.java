package com.ibm.esw.lms.sprintboot.starter.self.controller;

import com.ibm.esw.lms.springboot.starter.annotation.annotation.LoggerAnnotation;
import com.ibm.esw.lms.springboot.starter.self.service.SelfBootStarterService;
import com.ibm.esw.lms.sprintboot.starter.self.controller.dto.GeneralUserResponse;
import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/exceptions", method = RequestMethod.GET)
    @LoggerAnnotation
    public int throwException(){
        int i = 9/0;
        log.info("result : {}", i);
        return i;
    }

    @ApiOperation(value = "get user details")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "user_id", required = true, dataType = "string", paramType = "path")
    })
    @GetMapping("/user/{user_id}")
    public GeneralUserResponse getUser(@PathVariable("user_id") String userId) {
        User user = User.builder().id(userId).name("testUser").age(100).comment("test user comment").build();
        GeneralUserResponse response = new GeneralUserResponse(user);
        return response;
    }

}

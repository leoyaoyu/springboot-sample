package com.ibm.esw.lms.springboot.starter.annotation.annotation;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 503);
        map.put("msg", ex.getMessage());
        return map;
    }

}

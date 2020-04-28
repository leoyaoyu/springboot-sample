package com.ibm.esw.lms.springboot.starter.annotation.annotation;

import com.ibm.esw.lms.springboot.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
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

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map handlerNotValidException(MethodArgumentNotValidException exception) {
//        StringBuffer message = new StringBuffer();
//        if(exception.getBindingResult().hasErrors()){
//            exception.getBindingResult().getAllErrors().stream()
//                    .forEach(objectError -> message.append(objectError.getDefaultMessage()));
//        }
//        else{
//            message.append("Invalid message");
//        }
//        Map result = new HashMap();
//        result.put("code", HttpServletResponse.SC_BAD_REQUEST);
//        result.put("message", message);
//        return result;
//    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handlerNotValidException(MethodArgumentNotValidException exception) {
        log.warn("begin resolve argument exception");
        StringBuffer message = new StringBuffer();
        if(exception.getBindingResult().hasErrors()){
            exception.getBindingResult().getAllErrors().stream()
                    .forEach(objectError -> message.append(objectError.getDefaultMessage()));
        }
        else{
            message.append("Invalid message");
        }
        return BaseResponse.builder()
                .code(HttpServletResponse.SC_BAD_REQUEST)
                .message(message.toString())
                .build();
    }


    @ExceptionHandler(Throwable.class)
    public BaseResponse handlerGeneralError(Throwable e) {
        log.error("general error handler check error e {}", e.getMessage());
        return BaseResponse.builder()
                .code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
    }
}

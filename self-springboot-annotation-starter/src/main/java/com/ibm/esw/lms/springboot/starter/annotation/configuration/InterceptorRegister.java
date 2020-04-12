package com.ibm.esw.lms.springboot.starter.annotation.configuration;

import com.ibm.esw.lms.springboot.starter.annotation.annotation.LoggerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

//    @Bean
//    public HandlerInterceptor loggerInterceptor(){
//        return new LoggerInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(loggerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/error")
//                .excludePathPatterns("/static/*");
//    }

}
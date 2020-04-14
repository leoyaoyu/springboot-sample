package com.ibm.esw.lms.springboot.starter.annotation.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        LoggerAnnotation loggerAnnotation = method.getAnnotation(LoggerAnnotation.class);
        if (loggerAnnotation != null) {
            long startTime = System.currentTimeMillis();
            request.setAttribute("start_time", startTime);
            log.info("The method {} is started at {}", method.getName(), startTime);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoggerAnnotation loggerAnnotation = method.getAnnotation(LoggerAnnotation.class);
        if (loggerAnnotation != null) {
            long endTime = System.currentTimeMillis();
            long startTime = (Long) request.getAttribute("start_time");
            long periodTime = endTime - startTime;
            log.info("The method {} is finished at {}", method.getName(), endTime);
            log.info("The method {} took {} ms to execution", method.getName(), periodTime);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        if(ex != null) {
            log.info("ex message : {}",ex.getMessage());
            response.setStatus(503);
            PrintWriter output = response.getWriter();
            Map<String, String> result = new HashMap<>();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            String message = "Exception happened in method "+ method.getName();
            log.info(message);
            output.write(message);
        }
    }
}


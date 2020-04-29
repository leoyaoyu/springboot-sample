package com.ibm.esw.lms.sprintboot.starter.self.service.impl;

import com.ibm.esw.lms.sprintboot.starter.self.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validateUserId(String userId) {
        return userId.startsWith("A");
    }
}

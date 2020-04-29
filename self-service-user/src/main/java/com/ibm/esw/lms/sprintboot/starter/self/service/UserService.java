package com.ibm.esw.lms.sprintboot.starter.self.service;

import com.ibm.esw.lms.sprintboot.starter.self.controller.dto.CreateUserRequest;
import com.ibm.esw.lms.sprintboot.starter.self.dao.repo.UserRepository;
import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Slf4j
@Service
//@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;
    /*
    private final UserRepository userRepository;
    private final ValidationService validationService;
    */

    public Optional<User> getUserByNameAndAge(String name, Integer age){
        return userRepository.findByNameAndAge(name, age);
    }

    public User saveUser(CreateUserRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(request, User.class);
        return userRepository.save(user);
    }

    public void deleteUserByName(String name) {
        userRepository.deleteByName(name);
    }

    public void deleteByAge(Integer age) {
        userRepository.deleteByAge(age);
    }

    public boolean validUserId(String userId) {
        return validationService.validateUserId(userId);
    }
}

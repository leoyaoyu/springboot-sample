package com.ibm.esw.lms.sprintboot.starter.self.service;

import com.ibm.esw.lms.sprintboot.starter.self.controller.dto.CreateUserRequest;
import com.ibm.esw.lms.sprintboot.starter.self.dao.repo.UserRepository;
import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import com.ibm.esw.lms.sprintboot.starter.self.service.impl.ValidationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Spy
    private ValidationServiceImpl validationService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    @Spy
    private UserService userService;

    private User user;
    private Optional<User> userOptional;

    private String userId = "A00000XX1";
    private String userName = "test_user_name";
    private Integer userAge = 21;
    private String comment = "this is the comment for user 1";

    @Before
    public void init() {
        user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setAge(userAge);
        user.setComment(comment);
        userOptional = Optional.of(user);
    }

    @Test
    public void getUserByNameAndAge() {
        when(userRepository.findByNameAndAge(userName, userAge)).thenReturn(userOptional);
        Optional<User> u = userService.getUserByNameAndAge(userName, userAge);
        log.info("optional user is {}", u);
        assertTrue(u.isPresent());
    }

    @Test
    public void saveUser() {
        ModelMapper modelMapper = new ModelMapper();
        CreateUserRequest request = modelMapper.map(user, CreateUserRequest.class);
        User user1 =  modelMapper.map(request, User.class);
        when(userRepository.save(user1)).thenReturn(user);
        User u = userService.saveUser(request);
        log.info(" user is {}", u);
        assertThat(u, hasProperty("id"));
    }

    @Test
    public void validUserId() {
        boolean result = userService.validUserId(this.userId);
        assertTrue(result);
    }

    @Test
    public void deleteUserByName() {
    }

    @Test
    public void deleteByAge() {
    }
}

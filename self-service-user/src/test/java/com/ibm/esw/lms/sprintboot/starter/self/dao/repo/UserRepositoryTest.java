package com.ibm.esw.lms.sprintboot.starter.self.dao.repo;

import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    String userId = "A000000XX1";
    String userName = "user_name_tester1";
    String comment = "user_comments";
    Integer age = 24;

    @Test
    public void saveUser(){
        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setAge(age);
        user.setComment(comment);
        userRepository.save(user);
    }

    @Test
    public void findByNameAndAge() {
        Optional<User> user = userRepository.findByNameAndAge(userName, age);
        log.info("find user by name{} and age {}, get {}", userName, age, user);
        assertTrue(user.isPresent());
    }

    @Test
    public void deleteByName() {
        Optional<User> user = userRepository.findByName(this.userName);
        log.info("user {} is existing in db", user);
        userRepository.deleteByName(this.userName);
        log.info("user with name {} has been removed from db", this.userName);
        Optional<User> user1 = userRepository.findByName(this.userName);
        log.info("user {} has been removed", user1);
        assertFalse(user1.isPresent());
    }

    @Test
    public void deleteByAge() {
    }
}

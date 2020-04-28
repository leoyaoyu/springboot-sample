package com.ibm.esw.lms.sprintboot.starter.self.dao.repo;

import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    Optional<User> findByNameAndAge(String name, Integer age);

    @Transactional
    void deleteByName(String name);

    @Transactional
    void deleteByAge(Integer age);
}

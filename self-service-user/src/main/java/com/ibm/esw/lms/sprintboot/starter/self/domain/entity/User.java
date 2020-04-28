package com.ibm.esw.lms.sprintboot.starter.self.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
@Data
public class User {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String comment;
}

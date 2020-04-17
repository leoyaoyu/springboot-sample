package com.ibm.esw.lms.sprintboot.starter.self.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private String id;

    private String name;

    private Integer age;

    private String comment;
}

package com.ibm.esw.lms.sprintboot.starter.self.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserRequest {

    @NotEmpty(message="user name should NOT be null")
    String name;

    @Size(min = 18, max = 100, message = "user age should be a legal age")
    @NotEmpty(message="user age should NOT be null")
    String age;

    String comment;

}

package com.ibm.esw.lms.sprintboot.starter.self.controller.dto;

import com.ibm.esw.lms.springboot.common.BaseResponse;
import com.ibm.esw.lms.sprintboot.starter.self.domain.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GeneralUserResponse extends BaseResponse {
    private User user;
}

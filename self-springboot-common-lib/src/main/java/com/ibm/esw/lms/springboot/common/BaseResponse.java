package com.ibm.esw.lms.springboot.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {
    private String message;

    @Builder.Default
    private Integer code = ResultCode.SUCCESS.code;

    public boolean isSuccess() {
        return code == ResultCode.SUCCESS.code;
    }
}
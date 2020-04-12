package com.ibm.esw.lms.springboot.starter.self.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString
@ConfigurationProperties(prefix = "self.starter")
public class SelfProperties {
    private String host = "localhost";
    private String port = "8888";
    private String serviceName = "self-service";

}

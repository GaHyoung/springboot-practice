package com.nhnacademy.edu.springboot.student.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "com.nhn.student.system")
@Getter @Setter
public class SystemProperties {
    private String version;
}

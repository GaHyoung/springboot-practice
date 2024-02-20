package com.nhnacademy.edu.springboot.student.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="nhn.student", ignoreUnknownFields = true)
@Configuration
@Getter @Setter
public class StudentProperties {

    private String name;

}

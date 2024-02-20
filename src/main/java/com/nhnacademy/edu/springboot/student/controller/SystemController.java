package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.config.SystemProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SystemController {

    private final SystemProperties systemProperties;

    public SystemController(SystemProperties systemProperties) {
        this.systemProperties = systemProperties;
    }

    @GetMapping("/system/version")
    public Map<String, String> getSystem(){
        return Map.of("version", systemProperties.getVersion());
    }

}

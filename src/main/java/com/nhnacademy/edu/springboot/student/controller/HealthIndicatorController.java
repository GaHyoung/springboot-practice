package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.management.MyHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthIndicatorController {

    private final MyHealthIndicator myHealthIndicator;

    @PostMapping("management/fail")
    public void healthInfo(){
        //MyHealthIndicator 빈을 가져와서 false로 만들어주는 메서드 호출
        myHealthIndicator.setUnhealthy();
    }
}

package com.nhnacademy.edu.springboot.student.management;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component //빈으로 등록
public class AuthorInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        // "author" 키 아래에 "name" 값을 추가합니다.
        builder.withDetail("author", Map.of("name", "namGaHyoung"));
    }
}

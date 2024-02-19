package com.nhnacademy.edu.springboot.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //spring-boot 실행의 시작점
public class StudentApplication {

	public static void main(String[] args) {
		//spring-boot 시작 명령.
		//args를 넣지않으면 외부에서 넣는 인자가 넘어오지 않는 문제 발생할 수 있음.
		SpringApplication.run(StudentApplication.class, args);
	}

}

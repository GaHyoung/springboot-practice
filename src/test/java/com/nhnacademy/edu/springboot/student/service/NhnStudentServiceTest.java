package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.student.domain.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //통합테스트 -> 테스트하는과정에서 클래스가 모두 로딩됨.
class NhnStudentServiceTest {

    @Autowired
    StudentService studentService; //주입받기.

    @Test
    void getStudents() {
        List<Student> students = studentService.getStudents();

        Assertions.assertThat(students).hasSize(2);

    }
}
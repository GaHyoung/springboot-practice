package com.nhnacademy.edu.springboot.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.repository.StudentRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerMockMvcTest {

    @MockBean
    StudentRepository studentRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetStudents() throws Exception{

        given(studentRepository.findAll())
                .willReturn(List.of(new Student(1L, "AA", 100)));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo(("AA")))
        );



    }


    @Test
    @Order(2)
    void testGetStudent() throws Exception {

        given(studentRepository.findAll())
                .willReturn(List.of(new Student(1L, "AA", 100)));


        mockMvc.perform(get("/students/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo(("gahyoung"))));
    }


    @Test
    @Order(3)
    void testCreateStudent() throws Exception {

        Student student = new Student(100L, "manty", 100);
//        given(studentRepository.existsById(100L))
//                .willReturn(new Student(1L, "AA", 100));
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(
                        post("/students")
                                .content(mapper.writeValueAsString(student))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo(("manty"))))
                .andExpect(jsonPath("$.score", equalTo(100))
                );
    }

    @Test
    @Order(4)
    void deleteStudent() throws Exception{
        this.mockMvc.perform(delete("/students/{id}", 100L))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
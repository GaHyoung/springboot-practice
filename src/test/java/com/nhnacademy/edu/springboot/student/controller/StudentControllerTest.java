package com.nhnacademy.edu.springboot.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.student.domain.Student;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //order붙은 순서대로
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    void testGetStudents() throws Exception {
        //(MockMvcRequestBuilders.get으로 작성한 뒤 get에서 Art+Enter누른 후 add static을 누르면 get으로 선언된다.
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo(("gahyoung"))));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception {
        mockMvc.perform(get("/students/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo(("gahyoung"))));
    }


    @Test
    @Order(3)
    void testCreateStudent() throws Exception {

        Student student = new Student(100L, "manty", 100);
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
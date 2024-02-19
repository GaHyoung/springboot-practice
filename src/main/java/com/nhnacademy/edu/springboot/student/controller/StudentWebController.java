package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentWebController {

    @GetMapping("/web/students/{id}")//http://localhost:8080/web/students/1
    public String getStudent(@PathVariable("id")Long id, Model model){
        model.addAttribute("student", new Student(1L, "nam", 85));
        return "student";
    }

}

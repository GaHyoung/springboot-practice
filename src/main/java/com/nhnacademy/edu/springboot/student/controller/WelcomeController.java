package com.nhnacademy.edu.springboot.student.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {


    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("message", "Hello ");
        return "welcome";
    }
}
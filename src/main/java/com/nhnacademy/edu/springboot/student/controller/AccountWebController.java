package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountWebController {

    @GetMapping("/web/account/{id}") //http://localhost:8080/web/account/1
    public String getAccount(@PathVariable("id")Long id, Model model){
        model.addAttribute("account", new Account(1L, "500-", 10000));
        return "account";
    }

}

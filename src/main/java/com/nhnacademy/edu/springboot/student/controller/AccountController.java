package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.domain.Account;
import com.nhnacademy.edu.springboot.student.domain.ResultResponse;
import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("{id}")
    public Account getAccount(@PathVariable("id")Long id){
        return accountService.getAccount(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(Account account){
        return accountService.createAccount(account);
    }

    @DeleteMapping("{id}")
    public String deleteAccount(@PathVariable("id")Long id){
        accountService.deleteAccount(id);
        return "OK";
    }

}

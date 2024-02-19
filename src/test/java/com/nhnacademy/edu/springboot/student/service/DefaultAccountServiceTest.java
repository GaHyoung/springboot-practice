package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.student.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultAccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    void getAccounts() {
        List<Account> accounts = accountService.getAccounts();

        Assertions.assertThat(accounts).hasSize(2);
        Assertions.assertThat(accounts.get(0).getNumber()).isEqualTo("302-");
    }
}
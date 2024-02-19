package com.nhnacademy.edu.springboot.student.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;
}

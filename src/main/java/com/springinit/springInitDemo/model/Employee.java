package com.springinit.springInitDemo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String role;
}


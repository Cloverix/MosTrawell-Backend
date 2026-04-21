package org.example.dto;

import lombok.Data;

@Data
public class UserRegisterDto {
    private String name;
    private int age;
    private String login;
    private String password;
}

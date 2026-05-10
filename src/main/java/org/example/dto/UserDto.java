package org.example.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String login;
    private String name;
    private int age;
    private String avatarUrl;
    private Set<String> tags;
}

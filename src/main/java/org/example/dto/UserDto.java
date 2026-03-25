package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private int age;
    private String avatarUrl;
    private List<String> tags;
}

package org.example.service;

import org.example.dto.UserDto;
import org.example.dto.UserRegisterDto;

import java.util.Set;

public interface UserService {
    UserDto getById(Long id);

    UserDto register(UserRegisterDto dto);

    UserDto editName(Long id, String name);
    UserDto editTags(Long id, Set<String> tags);

    void delete(Long id);
}

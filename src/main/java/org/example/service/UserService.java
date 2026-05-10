package org.example.service;

import org.example.dto.UserDto;
import org.example.dto.UserRegisterDto;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface UserService {
    UserDto getById(Long id);
    UserDto getByName(String name);
    UserDto getByLogin(String login);

    UserDto register(UserRegisterDto dto);

    UserDto editName(Long id, String name);
    UserDto editTags(Long id, Set<String> tags);

    void delete(Long id);
}

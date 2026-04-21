package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.UserRegisterDto;
import org.example.entity.Tag;
import org.example.entity.User;
import org.example.exception.TagNotFoundException;
import org.example.exception.UserAlreadyExistsException;
import org.example.exception.UserNotFoundException;
import org.example.repository.TagRepository;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.util.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::convertToDto)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public UserDto register(UserRegisterDto dto) {
        User user = new User();

        if (userRepository.findByName(dto.getName()).isPresent()) {
            throw new UserAlreadyExistsException("User with name " + dto.getName() + " already exists");
        }

        user.setLogin(dto.getLogin());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setName(dto.getName());
        user.setAge(dto.getAge());

        return UserMapper.convertToDto(userRepository.save(user));
    }

    @Override
    public UserDto editName(Long id, String name) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setName(name);

        return UserMapper.convertToDto(userRepository.save(user));
    }

    @Override
    public UserDto editTags(Long id, Set<String> tags) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        Set<Tag> newTags = new HashSet<Tag>();
        for (String tagName : tags) {
            Tag tag = tagRepository.findByName(tagName).orElseThrow(() -> new TagNotFoundException("Tag not found"));
            newTags.add(tag);
        }

        user.setTags(newTags);
        return UserMapper.convertToDto(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

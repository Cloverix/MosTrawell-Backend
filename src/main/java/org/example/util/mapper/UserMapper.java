package org.example.util.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.UserDto;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UtilityClass
public class UserMapper {
    public UserDto convertToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setAvatarUrl(user.getAvatarUrl());
        Set<String> tagSet = new HashSet<>();
        user.getTags().forEach(tag -> {
            tagSet.add(tag.getName());
        });
        dto.setTags(tagSet);
        return dto;
    }
}

package org.example.service;

import org.example.dto.LandmarkDto;
import org.example.entity.Tag;

import java.util.List;
import java.util.Set;

public interface LandmarkService {
    LandmarkDto getById(Long id);
    List<LandmarkDto> getByName(String name);
    List<LandmarkDto> getByAddress(String address);
    //TODO: переделать для пагинации и оптимизировать кастомным SQL-запросом
    List<LandmarkDto> getByTags(Set<String> tagNames);
}

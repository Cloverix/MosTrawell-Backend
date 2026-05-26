package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.LandmarkDto;
import org.example.entity.Landmark;
import org.example.entity.Tag;
import org.example.exception.LandmarkNotFoundException;
import org.example.exception.TagNotFoundException;
import org.example.repository.LandmarkRepository;
import org.example.repository.TagRepository;
import org.example.service.LandmarkService;
import org.example.util.mapper.LandmarkMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LandmarkServiceImpl implements LandmarkService {
    private final LandmarkRepository landmarkRepository;
    private final TagRepository tagRepository;

    @Override
    public LandmarkDto getById(Long id) {
        return landmarkRepository.findById(id)
                .map(LandmarkMapper::convertToDto)
                .orElseThrow(() -> new LandmarkNotFoundException("Landmark not found"));
    }

    @Override
    public List<LandmarkDto> getByName(String name) {
        return landmarkRepository.findAllByNameContainingIgnoreCase(name).stream()
                .map(LandmarkMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LandmarkDto> getByAddress(String address) {
        return landmarkRepository.findAllByAddressContainingIgnoreCase(address).stream()
                .map(LandmarkMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LandmarkDto> getByTags(Set<String> tagNames) {
        Set<Tag> tags = tagRepository.findByNameIn(tagNames);
        if (tags.size() < tagNames.size()) {
            throw new TagNotFoundException("Tag not found");
        }

        Map<Landmark, Integer> matches = new HashMap<>();
        for (Landmark landmark : landmarkRepository.findAll()) {
            int matchCnt = 0;
            for (Tag landmarkTag : landmark.getTags()) {
                if (tags.contains(landmarkTag)) {
                    matchCnt++;
                }
            }
            matches.put(landmark, matchCnt);
        }

        return matches.entrySet().stream()
                .sorted(Map.Entry.<Landmark, Integer>comparingByValue().reversed())
                .map(entry -> LandmarkMapper.convertToDto(entry.getKey()))
                .collect(Collectors.toList());
    }
}

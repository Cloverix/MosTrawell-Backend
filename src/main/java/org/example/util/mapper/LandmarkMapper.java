package org.example.util.mapper;

import lombok.experimental.UtilityClass;
import org.example.dto.LandmarkDto;
import org.example.entity.Landmark;
import org.example.entity.Tag;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class LandmarkMapper {
    public LandmarkDto convertToDto(Landmark landmark) {
        LandmarkDto dto = new LandmarkDto();
        dto.setId(landmark.getId());
        dto.setName(landmark.getName());
        dto.setAddress(landmark.getAddress());
        dto.setDesc(landmark.getDesc());
        Set<String> tagSet = new HashSet<>();
        Set<Tag> landmarkTags = landmark.getTags();
        if (landmarkTags != null) {
            landmark.getTags().forEach(tag -> {
                tagSet.add(tag.getName());
            });
        }
        dto.setTags(tagSet);
        return dto;
    }
}

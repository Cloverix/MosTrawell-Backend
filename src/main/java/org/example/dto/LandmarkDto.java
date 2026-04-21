package org.example.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class LandmarkDto {
    private Long id;
    private String name;
    private String address;
    private String desc;
    private Set<String> tags;
}

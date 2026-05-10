package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.LandmarkDto;
import org.example.service.LandmarkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/landmark")
@RequiredArgsConstructor
public class LandmarkController {
    private final LandmarkService landmarkService;

    @GetMapping("/{id}")
    public ResponseEntity<LandmarkDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(landmarkService.getById(id));
    }

    @GetMapping("/search/byName")
    public ResponseEntity<List<LandmarkDto>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(landmarkService.getByName(name));
    }

    @GetMapping("/search/byAddress")
    public ResponseEntity<List<LandmarkDto>> getByAddress(@RequestParam String address) {
        return ResponseEntity.ok(landmarkService.getByAddress(address));
    }

    @GetMapping("/search/byTags")
    public ResponseEntity<List<LandmarkDto>> getByTags(@RequestParam(required = false) Set<String> tagNames) {
        if (tagNames == null || tagNames.isEmpty()) {
            return ResponseEntity.ok(landmarkService.getByTags(Collections.emptySet()));
        }
        return ResponseEntity.ok(landmarkService.getByTags(tagNames));
    }
}

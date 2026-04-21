package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.UserRegisterDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/id={id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestParam UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(userService.register(userRegisterDto));
    }

    @PatchMapping("/editName/{id}")
    public ResponseEntity<UserDto> editName(@PathVariable Long id, @RequestParam String name) {
        return ResponseEntity.ok(userService.editName(id, name));
    }

    @PatchMapping("/editTags/{id}")
    public ResponseEntity<UserDto> editTags(@PathVariable Long id, @RequestParam Set<String> tags) {
        return ResponseEntity.ok(userService.editTags(id, tags));
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

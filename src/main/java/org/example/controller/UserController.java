package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDto;
import org.example.dto.UserRegisterDto;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/login")
    public ResponseEntity<UserDto> login(Authentication authentication) {
        return ResponseEntity.ok(userService.getByLogin(authentication.getName()));
    }

    @GetMapping("/searchByLogin/{login}")
    public ResponseEntity<UserDto> searchByLogin(@PathVariable String login) {
        return ResponseEntity.ok(userService.getByLogin(login));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userRegisterDto));
    }

    @PatchMapping("/editName")
    public ResponseEntity<UserDto> editName(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(userService.editName(id, name));
    }

    @PatchMapping("/editTags")
    public ResponseEntity<UserDto> editTags(
            @RequestParam(name = "id") Long id,
            @RequestBody Set<String> tags) {
        return ResponseEntity.ok(userService.editTags(id, tags));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam(name = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

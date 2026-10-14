package com.example.ewalletback.controler;

import com.example.ewalletback.dto.request.UserRequestDto;
import com.example.ewalletback.dto.response.UserResponseDto;
import com.example.ewalletback.mapper.UserMapper;
import com.example.ewalletback.services.implemantations.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserMapper.toDto(userService.save(UserMapper.toEntity(request))));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(
                userService.findAll().stream()
                        .map(UserMapper::toDto)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(UserMapper.toDto(userService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(
            @PathVariable Long id,
            @RequestBody UserRequestDto request) {

        return ResponseEntity.ok(
                UserMapper.toDto(userService.update(id, UserMapper.toEntity(request)))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

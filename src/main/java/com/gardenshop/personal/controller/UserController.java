package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "Регистрация и управление аккаунтами")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Регистрация нового пользователя")
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto request) {
        UserResponseDto response = userService.register(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Получить свои данные")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> getMyProfile() {
        String email = getCurrentUserEmail();
        UserResponseDto response = userService.getByEmail(email);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Обновить свои данные")
    @PutMapping("/me")
    public ResponseEntity<UserResponseDto> updateMyProfile(@RequestBody UserRequestDto request) {
        String email = getCurrentUserEmail();
        UserResponseDto response = userService.update(email, request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Удалить свой аккаунт")
    @DeleteMapping("/me")
    public ResponseEntity<Void> deleteMyProfile() {
        String email = getCurrentUserEmail();
        userService.delete(email);
        return ResponseEntity.noContent().build();
    }

    private String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

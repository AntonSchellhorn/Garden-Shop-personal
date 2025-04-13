package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.user.LoginRequestDto;
import com.gardenshop.personal.service.interfaces.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация", description = "Логин пользователей через JWT")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Вход по email и паролю")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
}

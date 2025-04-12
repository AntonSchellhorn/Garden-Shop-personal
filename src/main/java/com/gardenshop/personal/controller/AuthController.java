package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.user.LoginRequestDto;
import com.gardenshop.personal.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }
}

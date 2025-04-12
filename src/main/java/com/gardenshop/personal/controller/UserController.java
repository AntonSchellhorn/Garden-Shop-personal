package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto request) {
        UserResponseDto response = userService.register(request);
        return ResponseEntity.ok(response);
    }
}

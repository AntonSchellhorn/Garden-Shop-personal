package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.user.LoginRequestDto;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.security.jwt.JwtUtil;
import com.gardenshop.personal.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Неверный пароль");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}

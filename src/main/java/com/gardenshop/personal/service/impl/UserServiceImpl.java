package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.exception.UserNotFoundException;
import com.gardenshop.personal.mapper.UserMapper;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.model.user.Role;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRequestDto request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }
        if (userRepository.existsByPhoneNumber(request.phoneNumber())) {
            throw new IllegalArgumentException("Пользователь с таким телефоном уже существует");
        }

        User user = userMapper.toEntity(request);
        user.setRole(Role.USER);

        return userMapper.toDto(userRepository.save(user));
    }



    @Override
    public UserResponseDto getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDto update(String email, UserRequestDto request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

        user.setName(request.name());
        user.setPhoneNumber(request.phoneNumber());
        user.setEmail(request.email());

        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void delete(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

        userRepository.delete(user);
    }
}

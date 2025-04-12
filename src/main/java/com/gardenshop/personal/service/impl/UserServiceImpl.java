package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.mapper.UserMapper;
import com.gardenshop.personal.model.user.Role;
import com.gardenshop.personal.model.user.User;
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
        User user = userMapper.toEntity(request);
        user.setRole(Role.USER); // по умолчанию
        return userMapper.toDto(userRepository.save(user));
    }
}

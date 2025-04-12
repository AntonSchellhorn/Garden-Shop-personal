package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setRole(user.getRole().name()); // enum → строка
        return dto;
    }
}

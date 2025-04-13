package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.name());                        // Имя
        user.setEmail(dto.email());                      // Почта
        user.setPassword(dto.password());                // Пароль
        user.setPhoneNumber(dto.phoneNumber());          // Телефон
        return user;
    }

    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),                                // ID пользователя
                user.getName(),                              // Имя
                user.getEmail(),                             // Почта
                user.getPhoneNumber(),                       // Телефон
                user.getRole().name()                        // Роль (enum → String)
        );
    }
}

package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto request);

    UserResponseDto getByEmail(String email);

    UserResponseDto update(String email, UserRequestDto request);

    void delete(String email);

}

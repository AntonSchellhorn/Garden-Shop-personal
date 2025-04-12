package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.user.UserRequestDto;
import com.gardenshop.personal.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRequestDto request);
}

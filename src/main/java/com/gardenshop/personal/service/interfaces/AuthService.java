package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.user.LoginRequestDto;

public interface AuthService {
    String login(LoginRequestDto request);
}

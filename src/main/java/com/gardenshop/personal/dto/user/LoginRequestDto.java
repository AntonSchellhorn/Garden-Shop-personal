package com.gardenshop.personal.dto.user;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}

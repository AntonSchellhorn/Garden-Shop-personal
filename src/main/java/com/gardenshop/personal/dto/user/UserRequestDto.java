package com.gardenshop.personal.dto.user;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}

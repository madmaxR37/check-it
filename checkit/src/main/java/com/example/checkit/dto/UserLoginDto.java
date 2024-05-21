package com.example.checkit.dto;

import lombok.Data;

@Data
public class UserLoginDto {

    private String credential;

    private String password;
}

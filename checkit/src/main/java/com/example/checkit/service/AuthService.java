package com.example.checkit.service;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.UserDto;
import com.example.checkit.dto.UserLoginDto;

public interface AuthService  {

    UserDto create(UserDto userDto);

    UserDto authenticate(UserLoginDto userLoginDto);
}

package com.example.checkit.controllers;

import com.example.checkit.dto.LogInResponse;
import com.example.checkit.dto.UserDto;
import com.example.checkit.dto.UserLoginDto;
import com.example.checkit.dto.mappers.UserMapper;
import com.example.checkit.security.JwtService;
import com.example.checkit.service.serviceImplementation.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/auth")
public class AuthController {

    private final JwtService jwtService;

    private final AuthServiceImpl authenticationService;

    public AuthController(JwtService jwtService, AuthServiceImpl authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        UserDto user = authenticationService.create(userDto);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LogInResponse> authenticate(@RequestBody UserLoginDto loginUserDto) {
        UserDto authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(UserMapper.userDtoToUser(authenticatedUser));

        LogInResponse loginResponse = new LogInResponse();
        loginResponse.setToken(jwtToken);

        return ResponseEntity.ok(loginResponse);
    }
}

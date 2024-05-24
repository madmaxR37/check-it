package com.example.checkit.controllers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.service.serviceImplementation.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/client/create")
    public ClientDto createClient(@RequestBody ClientDto clientDto){
        userService.createUser(clientDto);
        return clientDto;
    }
}

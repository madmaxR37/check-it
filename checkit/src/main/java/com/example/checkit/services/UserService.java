package com.example.checkit.services;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void createUser(Object userDto);

    String setProfile(Long userId, MultipartFile file);

}

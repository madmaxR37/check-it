package com.example.checkit.services;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    void createUser(Object userDto);

    String setProfile(Long userId, MultipartFile file);

    String setNIC(Long userId, List<MultipartFile> multipartFiles);

    String setDrivingLicence(Long userId, List<MultipartFile> multipartFiles);

}

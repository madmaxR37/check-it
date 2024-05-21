package com.example.checkit.dto.mappers;

import com.example.checkit.dto.UserDto;
import com.example.checkit.model.User;

public class UserMapper {

    public static User userDtoToUser(UserDto userDto){
        return new User().setFirstname(userDto.getFirstname())
                .setSurname(userDto.getSurname())
                .setPhoneNumber(userDto.getPhoneNumber())
                .setActiveStatus(userDto.getActiveStatus())
                .setProfileUrl(userDto.getProfileUrl())
                .setEmail(userDto.getEmail())
                .setPassword(userDto.getPassword());
    }

    public static UserDto userToUserDto(User user){
        return new UserDto().setCreatedDate(user.getCreatedDate())
                .setFirstname(user.getFirstname())
                .setPassword(user.getPassword())
                .setId(user.getId())
                .setSurname(user.getSurname())
                .setPhoneNumber(user.getPhoneNumber())
                .setActiveStatus(user.getActiveStatus())
                .setAccountBalance(user.getAccountBalance())
                .setRole(user.getRole())
                .setProfileUrl(user.getProfileUrl());

    }
}

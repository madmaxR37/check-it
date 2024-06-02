package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.dtos.mappers.UserMapper;
import com.example.checkit.exceptions.EntityAlreadyExistException;
import com.example.checkit.models.User;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(Object userDto) {
        Optional<Object> userOptional;
        User user;
        user = UserMapper.userDtoToUser(userDto);
        userOptional = userRepository.findUserByEmailOrPhoneNumber(user.getEmail(),user.getPhoneNumber());
        if (userOptional.isPresent()){
            throw new EntityAlreadyExistException("user with email or number already exist",
                    HttpStatus.BAD_REQUEST);
        }
        user.setAccountBalance((float)0);
        user.setActiveStatus(userDto instanceof ClientDto);
        userRepository.save(user);
    }
}

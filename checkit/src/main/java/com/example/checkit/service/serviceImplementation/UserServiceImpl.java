package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.mappers.UserMapper;
import com.example.checkit.model.User;
import com.example.checkit.repository.UserRepository;
import com.example.checkit.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(Object userDto) {
        User user;
        user = UserMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }
}

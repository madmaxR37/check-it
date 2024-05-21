package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.UserDto;
import com.example.checkit.dto.UserLoginDto;
import com.example.checkit.dto.mappers.ClientMapper;
import com.example.checkit.dto.mappers.UserMapper;
import com.example.checkit.model.Client;
import com.example.checkit.model.User;
import com.example.checkit.repository.UserRepository;
import com.example.checkit.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;


    public AuthServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
       return UserMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    public UserDto authenticate(UserLoginDto userLoginDto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDto.getCredential(),
                        userLoginDto.getPassword()
                )
        );

        return ClientMapper.clientToClientDto((Client) userRepository.findUserByEmail(userLoginDto.getCredential()).get());
    }


}

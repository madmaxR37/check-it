package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.dtos.mappers.UserMapper;
import com.example.checkit.exceptions.EntityAlreadyExistException;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.User;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.UserService;
import com.example.checkit.services.aws.S3BucketService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final S3BucketService bucketService;

    public UserServiceImpl(UserRepository userRepository, S3BucketService bucketService) {
        this.userRepository = userRepository;
        this.bucketService = bucketService;
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

    @Override
    public String setProfile(Long userId, MultipartFile file) {
        Optional<User> user;
        user = userRepository.findById(userId);
         if (user.isEmpty()){
             throw new EntityNotFoundException("user not found", HttpStatus.NOT_FOUND);
         }
         String imageurl = bucketService.uploadFile(file);
         if (imageurl.isEmpty()){
             System.out.println("an error occured during");
             return "an error occured";
         }
         User userModel =user.get();
         userModel.setProfileUrl(imageurl);
         userRepository.save(userModel);
        return "image store successfully";

    }
}

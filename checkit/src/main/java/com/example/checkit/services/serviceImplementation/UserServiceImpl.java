package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.dtos.mappers.UserMapper;
import com.example.checkit.exceptions.EntityAlreadyExistException;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.DeliveryMan;
import com.example.checkit.models.Seller;
import com.example.checkit.models.User;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.UserService;
import com.example.checkit.services.externalServices.S3BucketService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
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
         String imageUrl = bucketService.uploadFile(file);
         if (imageUrl.isEmpty()){
             System.out.println("an error occured during");
             return "an error occured";
         }
         User userModel =user.get();
         userModel.setProfileUrl(imageUrl);
         userRepository.save(userModel);
        return "image store successfully";

    }

    @Override
    public String setNIC(Long userId, List<MultipartFile> multipartFiles) {
        Optional<User> userOptional =  userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new EntityNotFoundException("user not found", HttpStatus.NOT_FOUND);
        }
       List <String> urls = bucketService.uploadFiles(multipartFiles);
        User user = userOptional.get();
         if (user instanceof Seller seller){
             seller.setNationalId(urls);
             userRepository.save(seller);
         } else if (user instanceof DeliveryMan deliveryMan) {
              deliveryMan.setNicImagesUrls(urls);
              userRepository.save(deliveryMan);
         }

        return "images store successfully";
    }

    @Override
    public String setDrivingLicence(Long userId, List<MultipartFile> multipartFiles) {
        Optional<User> userOptional =  userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new EntityNotFoundException("user not found", HttpStatus.NOT_FOUND);
        }

        List<String> urls = bucketService.uploadFiles(multipartFiles);

        User user = userOptional.get();

        DeliveryMan deliveryMan = (DeliveryMan) user;
        deliveryMan.setDrivingLicenseUrls(urls);
        userRepository.save(deliveryMan);
        return "images store successfully";
    }
}

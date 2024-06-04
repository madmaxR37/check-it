package com.example.checkit.controllers;

import com.example.checkit.dtos.ClientDto;
import com.example.checkit.dtos.DeliveryManDto;
import com.example.checkit.dtos.SellerDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("check-it/v1/users/auth")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/client/create")
    public ResponseEntity<Object> createClient(@Validated @RequestBody ClientDto clientDto){
        userService.createUser(clientDto);
        return ResponseHandler.generateResponse("User created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/seller/create")
    public ResponseEntity<Object> createSeller(@Validated @RequestBody SellerDto sellerDto){
        userService.createUser(sellerDto);
        return ResponseHandler.generateResponse("Seller created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/deliveryman/create")
    public ResponseEntity<Object> createDeliveryMan(@Validated @RequestBody DeliveryManDto deliveryManDto){
        userService.createUser(deliveryManDto);
        return ResponseHandler.generateResponse("DeliveryMan created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/profile/{userId}")
    public ResponseEntity<Object> setProfile(@PathVariable Long userId, @RequestParam("file") MultipartFile file){
        String message = userService.setProfile(userId, file);

        return ResponseHandler.generateResponse(message, HttpStatus.OK);
    }
}

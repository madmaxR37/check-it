package com.example.checkit.controllers;

import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.dto.SellerDto;
import com.example.checkit.handler.ResponseHandler;
import com.example.checkit.service.serviceImplementation.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/users/auth")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/client/create")
    public ResponseEntity<Object> createClient(@RequestBody ClientDto clientDto){
        userService.createUser(clientDto);
        return ResponseHandler.generateResponse("User created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/seller/create")
    public ResponseEntity<Object> createSeller(@RequestBody SellerDto sellerDto){
        userService.createUser(sellerDto);
        return ResponseHandler.generateResponse("Seller created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/deliveryman/create")
    public ResponseEntity<Object> createDeliveryMan(@RequestBody DeliveryManDto deliveryManDto){
        userService.createUser(deliveryManDto);
        return ResponseHandler.generateResponse("DeliveryMan created successfully", HttpStatus.CREATED);
    }
}
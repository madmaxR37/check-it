package com.example.checkit.controllers;

import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.service.serviceImplementation.DeliveryManServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/delivery-man")
public class DeliveryManController {

    private final DeliveryManServiceImp deliveryManServiceImp;

    public DeliveryManController(DeliveryManServiceImp deliveryManServiceImp) {
        this.deliveryManServiceImp = deliveryManServiceImp;
    }

    @PostMapping("/create")
    public DeliveryManDto createDeliveryMan(@RequestBody DeliveryManDto deliveryManDto){
        return deliveryManServiceImp.create(deliveryManDto);
    }
}

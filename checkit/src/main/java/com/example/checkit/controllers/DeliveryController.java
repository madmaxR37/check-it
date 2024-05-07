package com.example.checkit.controllers;

import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.service.serviceImplementation.DeliveryServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/delivery")
public class DeliveryController {

    private final DeliveryServiceImp deliveryServiceImp;

    public DeliveryController(DeliveryServiceImp deliveryServiceImp) {
        this.deliveryServiceImp = deliveryServiceImp;
    }

    @PostMapping("/create")
    public DeliveryDto createDelivery(@RequestBody DeliveryDto deliveryDto){
        return deliveryServiceImp.createDelivery(deliveryDto);
    }
}

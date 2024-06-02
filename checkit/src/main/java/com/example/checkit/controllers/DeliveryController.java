package com.example.checkit.controllers;

import com.example.checkit.dtos.DeliveryDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.DeliveryServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/delivery")
public class DeliveryController {

    private final DeliveryServiceImp deliveryServiceImp;

    public DeliveryController(DeliveryServiceImp deliveryServiceImp) {
        this.deliveryServiceImp = deliveryServiceImp;
    }

    @PostMapping("/create/{sellerId}/{orderId}")
    public ResponseEntity<Object> createDelivery(@Validated  @RequestBody DeliveryDto deliveryDto, @PathVariable Long orderId, @PathVariable Long sellerId){
       DeliveryDto dto = deliveryServiceImp.createDelivery(deliveryDto, orderId,sellerId);
        return ResponseHandler.generateResponseData("Delivery Created", HttpStatus.CREATED,dto);

    }
}

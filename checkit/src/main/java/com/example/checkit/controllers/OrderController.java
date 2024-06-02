package com.example.checkit.controllers;

import com.example.checkit.services.serviceImplementation.OrderServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/order")
public class OrderController {

    private final OrderServiceImp orderServiceImp;

    public OrderController(OrderServiceImp orderServiceImp) {
        this.orderServiceImp = orderServiceImp;
    }

}

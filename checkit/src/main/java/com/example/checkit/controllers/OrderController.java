package com.example.checkit.controllers;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.service.serviceImplementation.OrderServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/order")
public class OrderController {

    private final OrderServiceImp orderServiceImp;

    public OrderController(OrderServiceImp orderServiceImp) {
        this.orderServiceImp = orderServiceImp;
    }

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody TransactionDto transactionDto){
        return orderServiceImp.createOrder(transactionDto);
    }
}

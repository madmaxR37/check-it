package com.example.checkit.controllers;

import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.service.serviceImplementation.PreOrderServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/pre-order")
public class PreOrderController {

    private final PreOrderServiceImp preOrderServiceImp;

    public PreOrderController(PreOrderServiceImp preOrderServiceImp) {
        this.preOrderServiceImp = preOrderServiceImp;
    }

    @PostMapping("/save")
    public PreOrderDto createPreOrder(@RequestBody PreOrderDto preOrderDto){
        return preOrderServiceImp.createPreOrder(preOrderDto);
    }
}

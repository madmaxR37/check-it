package com.example.checkit.controllers;

import com.example.checkit.dtos.PreOrderDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.PreOrderServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/pre-order")
public class PreOrderController {

    private final PreOrderServiceImp preOrderServiceImp;

    public PreOrderController(PreOrderServiceImp preOrderServiceImp) {
        this.preOrderServiceImp = preOrderServiceImp;
    }

    @PostMapping("/save/{cartId}")
    public ResponseEntity<Object> createPreOrder(@Validated  @RequestBody PreOrderDto preOrderDto, @PathVariable Long cartId){
         PreOrderDto  preOrder = preOrderServiceImp.createPreOrder(preOrderDto,cartId);
        return ResponseHandler.generateResponseData("PreOder Created!", HttpStatus.CREATED,preOrder);
    }
}

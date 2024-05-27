package com.example.checkit.controllers;

import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.handler.ResponseHandler;
import com.example.checkit.service.serviceImplementation.PreOrderServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/pre-order")
public class PreOrderController {

    private final PreOrderServiceImp preOrderServiceImp;

    public PreOrderController(PreOrderServiceImp preOrderServiceImp) {
        this.preOrderServiceImp = preOrderServiceImp;
    }

    @PostMapping("/save/{cartId}")
    public ResponseEntity<Object> createPreOrder(@RequestBody PreOrderDto preOrderDto, @PathVariable Long cartId){
         PreOrderDto  preOrder = preOrderServiceImp.createPreOrder(preOrderDto,cartId);
        return ResponseHandler.generateResponseData("PreOder Created!", HttpStatus.CREATED,preOrder);
    }
}

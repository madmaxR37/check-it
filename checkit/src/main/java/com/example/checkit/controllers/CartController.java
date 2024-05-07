package com.example.checkit.controllers;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.service.serviceImplementation.CartServiceImp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/cart")
public class CartController {


    private final CartServiceImp cartServiceImp;

    public CartController(CartServiceImp cartServiceImp) {
        this.cartServiceImp = cartServiceImp;
    }

    @PostMapping("/save/{clientId}")
    public CartDto createCart(@RequestBody PurchaseLineDto purchaseLineDto, @PathVariable Long clientId){
        return cartServiceImp.createCard(purchaseLineDto, clientId);
    }
}

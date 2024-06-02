package com.example.checkit.controllers;

import com.example.checkit.dtos.CartDto;
import com.example.checkit.dtos.PurchaseLineDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.CartServiceImp;
import com.example.checkit.services.serviceImplementation.PurchaseLineServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/cart")
public class CartController {


    private final CartServiceImp cartServiceImp;
    private final PurchaseLineServiceImp purchaseLineServiceImp;

    public CartController(CartServiceImp cartServiceImp, PurchaseLineServiceImp purchaseLineServiceImp) {
        this.cartServiceImp = cartServiceImp;
        this.purchaseLineServiceImp = purchaseLineServiceImp;
    }

    @PostMapping("/save/{clientId}/{itemId}")
    public ResponseEntity<Object> createCart(@PathVariable Long clientId, @PathVariable Long itemId, @Validated @RequestBody PurchaseLineDto purchaseLineDto){
        Long purchaseLineId = purchaseLineServiceImp.createPurchaseLine(itemId, purchaseLineDto);
        CartDto cartDto = cartServiceImp.createCard(clientId,purchaseLineId);
        return ResponseHandler.generateResponseData("Card created", HttpStatus.CREATED,cartDto);
    }
}

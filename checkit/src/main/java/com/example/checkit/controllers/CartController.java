package com.example.checkit.controllers;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.handler.ResponseHandler;
import com.example.checkit.service.serviceImplementation.CartServiceImp;
import com.example.checkit.service.serviceImplementation.PurchaseLineServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> createCart(@PathVariable Long clientId, @PathVariable Long itemId, @RequestBody PurchaseLineDto purchaseLineDto){
        Long purchaseLineId = purchaseLineServiceImp.createPurchaseLine(itemId, purchaseLineDto);
        CartDto cartDto = cartServiceImp.createCard(clientId,purchaseLineId);
        return ResponseHandler.generateResponseData("Card created", HttpStatus.CREATED,cartDto);
    }
}

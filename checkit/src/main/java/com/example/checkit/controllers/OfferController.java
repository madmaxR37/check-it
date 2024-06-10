package com.example.checkit.controllers;

import com.example.checkit.dtos.OfferDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.OfferServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/offers")
public class OfferController {

    private final OfferServiceImpl offerService;

    public OfferController(OfferServiceImpl offerService) {
        this.offerService = offerService;
    }

    @PostMapping("/create/{cartId}")
    public ResponseEntity<Object> createOffer(@RequestBody OfferDto offerDto, @PathVariable Long cartId){
        offerService.createOffer(cartId, offerDto);
        return ResponseHandler.generateResponse("offer created", HttpStatus.CREATED);
    }
}

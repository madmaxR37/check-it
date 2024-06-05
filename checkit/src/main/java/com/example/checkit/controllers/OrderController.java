package com.example.checkit.controllers;

import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.externalServices.QRGeneratorService;
import com.example.checkit.services.serviceImplementation.OrderServiceImp;
import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/order")
public class OrderController {

    private final OrderServiceImp orderServiceImp;

    private final QRGeneratorService qrGeneratorService;

    public OrderController(OrderServiceImp orderServiceImp, QRGeneratorService qrGeneratorService) {
        this.orderServiceImp = orderServiceImp;
        this.qrGeneratorService = qrGeneratorService;
    }

    @PostMapping("/generate-qr/{id}")
    public ResponseEntity<Object> generateQRCode(@PathVariable Long id){
        try {
            qrGeneratorService.generateQRCode(id,250,250);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        return ResponseHandler.generateResponse("Successfull", HttpStatus.OK);
    }

}

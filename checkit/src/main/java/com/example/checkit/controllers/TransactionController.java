package com.example.checkit.controllers;

import com.example.checkit.dtos.CreditCardDto;
import com.example.checkit.dtos.MobileDto;
import com.example.checkit.dtos.TransactionDto;
import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.serviceImplementation.TransactionServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("check-it/v1/transaction")
public class TransactionController {

    private final TransactionServiceImp transactionServiceImp;

    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }


    @PostMapping("/{preOrderId}")
    public ResponseEntity<Object> transaction(@RequestBody TransactionDto transactionDto, @PathVariable Long preOrderId){
        Object transaction =transactionServiceImp.preOrderTransaction(transactionDto,preOrderId);
        return ResponseHandler.generateResponseData("Transaction successful !", HttpStatus.CREATED,transaction);
    }
    @PostMapping("/mobile/{preOrderId}")
    public ResponseEntity<Object> mobileTransaction(@Validated @RequestBody MobileDto mobileDto, @PathVariable Long preOrderId){
        Object transaction = transactionServiceImp.preOrderMobileTransaction(mobileDto, preOrderId);
        return ResponseHandler.generateResponseData("Transaction successful", HttpStatus.CREATED,transaction);
    }

    @PostMapping("/credit-card/{preOrderId}")
    public ResponseEntity<Object> cardTransaction(@Validated @RequestBody CreditCardDto creditCardDto, @PathVariable Long preOrderId){
        Object transaction = transactionServiceImp.preOrderCreditCardTransaction(creditCardDto, preOrderId);
        return ResponseHandler.generateResponseData("Transaction successful", HttpStatus.CREATED,transaction);
    }
}

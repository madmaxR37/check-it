package com.example.checkit.controllers;

import com.example.checkit.dto.CreditCardDto;
import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.dto.MobileDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.service.serviceImplementation.TransactionServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/transaction")
public class TransactionController {

    private final TransactionServiceImp transactionServiceImp;

    public TransactionController(TransactionServiceImp transactionServiceImp) {
        this.transactionServiceImp = transactionServiceImp;
    }

    @PostMapping("/create-mobile")
    public TransactionDto createMobileTransaction(@RequestBody MobileDto mobileDto){
        return transactionServiceImp.createOrderMobileTransaction(mobileDto);
    }

    @PostMapping("/create-credit-card")
    public TransactionDto createCreditCardTransaction(@RequestBody CreditCardDto creditCardDto){
        return transactionServiceImp.createOrderCreditCardTransaction(creditCardDto);
    }

    @PostMapping("/create-delivery-transaction")
    public TransactionDto createDeliveryTransaction(@RequestBody DeliveryDto deliveryDto){
        return transactionServiceImp.createDeliveryTransaction(deliveryDto);
    }
}

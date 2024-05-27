package com.example.checkit.controllers;

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




}

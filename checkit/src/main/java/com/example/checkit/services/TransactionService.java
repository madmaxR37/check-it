package com.example.checkit.services;

import com.example.checkit.dtos.CreditCardDto;
import com.example.checkit.dtos.MobileDto;
import com.example.checkit.dtos.TransactionDto;

public interface TransactionService {

    TransactionDto preOrderTransaction(TransactionDto transactionDto, Long preOrderId);

    MobileDto preOrderMobileTransaction(MobileDto mobileDto, Long preOrderId);

    CreditCardDto preOrderCreditCardTransaction(CreditCardDto creditCardDto, Long preOrderId);

}

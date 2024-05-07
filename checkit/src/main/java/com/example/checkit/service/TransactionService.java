package com.example.checkit.service;

import com.example.checkit.dto.CreditCardDto;
import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.dto.MobileDto;
import com.example.checkit.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createOrderMobileTransaction(MobileDto mobileDto);

    TransactionDto createOrderCreditCardTransaction(CreditCardDto creditCardDto);

    TransactionDto createDeliveryTransaction(DeliveryDto deliveryDto);
    TransactionDto updateTransaction(TransactionDto transactionDto);

    List<TransactionDto> findAllTransactionsBYUserId(Long id);
}

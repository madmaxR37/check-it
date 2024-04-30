package com.example.checkit.service;

import com.example.checkit.dto.CreditCartDto;
import com.example.checkit.dto.MobileDto;
import com.example.checkit.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransactionMobile(MobileDto mobileDto);

    TransactionDto createTransactionCreditCart(CreditCartDto creditCartDto);

    TransactionDto updateTransaction(TransactionDto transactionDto);

    List<TransactionDto> findAllTransactionsBYUserId(Long id);
}

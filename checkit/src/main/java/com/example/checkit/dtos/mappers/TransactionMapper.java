package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.TransactionDto;
import com.example.checkit.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    public static TransactionDto transactionToTransactionDto(Transaction transaction){
        return new TransactionDto()
                .setId(transaction.getId())
                .setCreatedDate(transaction.getCreatedDate())
                .setStatus(transaction.getStatus())
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(transaction.getPreOrder()))
                .setAmount(transaction.getAmount());
    }
    public static List<TransactionDto> transactionsToTransactionsDto(List<Transaction> transactions){
        List<TransactionDto> transactionsDto = new ArrayList<>();

        for (Transaction transaction: transactions){
            TransactionDto transactionDto = new TransactionDto()
                    .setId(transaction.getId())
                    .setCreatedDate(transaction.getCreatedDate())
                    .setStatus(transaction.getStatus())
                    .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(transaction.getPreOrder()));
            transactionsDto.add(transactionDto);

        }

        return transactionsDto;
    }
}

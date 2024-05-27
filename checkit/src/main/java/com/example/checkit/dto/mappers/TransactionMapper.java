package com.example.checkit.dto.mappers;

import com.example.checkit.dto.TransactionDto;
import com.example.checkit.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    public static TransactionDto transactionToTransactionDto(Transaction transaction){
        return new TransactionDto()
                .setId(transaction.getId())
                .setCreatedDate(transaction.getCreatedDate())
                .setStatus(transaction.getStatus())
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(transaction.getPreOrder()));
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

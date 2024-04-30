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

    public static Transaction transactionDtoToTransaction(TransactionDto transactionDto){
        return new Transaction()
                .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(transactionDto.getPreOrderDto()))
                .setStatus(transactionDto.getStatus())
                .setCreatedDate(transactionDto.getCreatedDate());
    }

    public static List<Transaction> transactionsDtoToTransactions(List<TransactionDto> transactionDtos){
        List<Transaction> transactions = new ArrayList<>();

        for(TransactionDto transactionDto: transactionDtos){
            Transaction transaction = new Transaction()
                    .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(transactionDto.getPreOrderDto()))
                    .setStatus(transactionDto.getStatus())
                    .setCreatedDate(transactionDto.getCreatedDate());
            transactions.add(transaction);
        }
        return transactions;
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

package com.example.checkit.repository;

import com.example.checkit.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {
}

package com.example.checkit.repository;

import com.example.checkit.model.PurchaseLine;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseLineRepository extends CrudRepository<PurchaseLine,Long> {
}

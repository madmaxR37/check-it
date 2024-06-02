package com.example.checkit.repositories;

import com.example.checkit.models.PurchaseLine;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseLineRepository extends CrudRepository<PurchaseLine,Long> {
}

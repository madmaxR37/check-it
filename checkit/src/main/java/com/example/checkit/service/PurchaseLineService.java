package com.example.checkit.service;

import com.example.checkit.dto.PurchaseLineDto;
import org.springframework.stereotype.Service;


public interface PurchaseLineService {

    public Long  createPurchaseLine(Long itemId, PurchaseLineDto purchaseLineDto);

    public void deletePurchaseLine(Long purchaseLineId);
}

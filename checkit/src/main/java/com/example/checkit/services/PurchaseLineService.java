package com.example.checkit.services;

import com.example.checkit.dtos.PurchaseLineDto;


public interface PurchaseLineService {

    public Long  createPurchaseLine(Long itemId, PurchaseLineDto purchaseLineDto);

    public void deletePurchaseLine(Long purchaseLineId);
}

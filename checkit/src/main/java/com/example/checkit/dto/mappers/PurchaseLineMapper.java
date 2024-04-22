package com.example.checkit.dto.mappers;

import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.model.PurchaseLine;

public class PurchaseLineMapper {

    public static PurchaseLine purchaseLineDtoToPurchaseLine(PurchaseLineDto purchaseLineDto){
        return new PurchaseLine()
                .setPrice(purchaseLineDto.getPrice())
                .setQuantity(purchaseLineDto.getQuantity())
                ;
    }

    public static PurchaseLineDto purchaseLineToPurchaseLineDto(PurchaseLine purchaseLine){
        return new PurchaseLineDto()
                .setId(purchaseLine.getId())
                .setPrice(purchaseLine.getPrice())
                .setQuantity(purchaseLine.getQuantity())
                ;
    }
}

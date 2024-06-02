package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.PurchaseLineDto;
import com.example.checkit.models.PurchaseLine;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLineMapper {

    public static  PurchaseLine purchaseLineDtoToPurchaseLine(PurchaseLineDto purchaseLineDto){
        return new PurchaseLine().setPrice(purchaseLineDto.getPrice())
                .setQuantity(purchaseLineDto.getQuantity());
    }

    public static PurchaseLineDto purchaseLineToPurchaseLineDto(PurchaseLine purchaseLine){
        return new PurchaseLineDto().setItemDto(ItemMapper.itemToItemDto(purchaseLine.getItem()))
                .setQuantity(purchaseLine.getQuantity())
                .setPrice(purchaseLine.getPrice())
                .setId(purchaseLine.getId());
    }
    public static List<PurchaseLine> purchaseLineDtoToPurchaseLines(List<PurchaseLineDto> purchaseLineDtos){

        List<PurchaseLine> purchaseLines = new ArrayList<>();
        for (PurchaseLineDto purchaseLineDto: purchaseLineDtos){
            PurchaseLine purchaseLine = new PurchaseLine();
            purchaseLine
                    .setPrice(purchaseLineDto.getPrice())
                    .setQuantity(purchaseLineDto.getQuantity())
                    .setItem(ItemMapper.itemDtoToItem(purchaseLineDto.getItemDto()));
            purchaseLines.add(purchaseLine);
        }


        return purchaseLines;
    }

    public static List<PurchaseLineDto> purchaseLineToPurchaseLineDtos(List<PurchaseLine> purchaseLines){

        List<PurchaseLineDto> purchaseLineDtos = new ArrayList<>();

        for (PurchaseLine purchaseLine: purchaseLines){
            PurchaseLineDto purchaseLineDto = new PurchaseLineDto();
            purchaseLineDto
                    .setId(purchaseLine.getId())
                    .setPrice(purchaseLine.getPrice())
                    .setQuantity(purchaseLine.getQuantity())
                    .setItemDto(ItemMapper.itemToItemDto(purchaseLine.getItem()));
            purchaseLineDtos.add(purchaseLineDto);
        }


        return purchaseLineDtos;
    }
}

package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CardDto {

    private Integer id;

    private Boolean isActiveStatus;

    private Integer totalItemsQuantity;

    private Float totalItemsCost;

    private List<PurchaseLineDto> purchaseLineDto;

}

package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CartDto {

    private Long id;

    private String name;

    private Long clientId;

    private Boolean isActiveStatus;

    private Integer totalItemsQuantity;

    private Float totalItemsCost;

    private List<PurchaseLineDto> purchaseLineDto;

    private ClientDto clientDto;

}

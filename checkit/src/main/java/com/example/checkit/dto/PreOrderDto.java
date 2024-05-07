package com.example.checkit.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PreOrderDto {

    private Long id;

    private String clientName;

    private String clientPhoneNumber;

    private Float tripDistance;

    private Float deliveryCost;

    private Float totalCost;

    private AddressDto clientAddressDto;

    private CartDto cartDto;


}

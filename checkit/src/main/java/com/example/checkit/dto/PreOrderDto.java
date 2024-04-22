package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PreOrderDto {

    private Integer id;

    private String clientName;

    private String clientPhoneNumber;

    private Long tripDistance;

    private Float deliveryCost;

    private Float totalCost;

    private AddressDto clientAddressDto;

    private CardDto cardDto;


}

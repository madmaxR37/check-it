package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class DeliveryDto {

    private Integer id;

    private String deliveryTitle;

    private Float deliveryCost;

    private Boolean acceptanceStatus;

    private String description;

    private String sellerPhoneNumber;

    private Boolean deliveryStatus;

    private AddressDto sellerLocation;

    private OrderDto orderDto;

    private DeliveryManDto deliveryManDto;

    private SellerDto sellerDto;
}

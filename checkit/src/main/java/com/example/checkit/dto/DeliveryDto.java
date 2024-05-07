package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@Accessors(chain = true)
public class DeliveryDto {

    private Long id;

    private String deliveryTitle;

    private Float deliveryCost;

    private Date createdDate;

    private Boolean acceptanceStatus;

    private Boolean paymentStatus;

    private Boolean assignationStatus;

    private String description;

    private String sellerPhoneNumber;

    private Boolean deliveryStatus;

    private AddressDto sellerLocation;

    private OrderDto orderDto;

    private DeliveryManDto deliveryManDto;

    private SellerDto sellerDto;

    private  TransactionDto transactionDto;
}

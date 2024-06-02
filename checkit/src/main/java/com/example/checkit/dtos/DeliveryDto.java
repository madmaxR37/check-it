package com.example.checkit.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class DeliveryDto {

    private Long id;

    @NotBlank(message = "delivery must have a title")
    private String deliveryTitle;

    private Float deliveryCost;

    private LocalDateTime createdDate;

    private Boolean acceptanceStatus;

    private Boolean paymentStatus;

    private Boolean assignationStatus;

    @NotBlank(message = "delivery must have a description")
    @Max(value = 500,message = "delivery description shouldn't be more than 500 words")
    private String description;

    @NotBlank(message = "delivery must have a seller number")
    private String sellerPhoneNumber;

    private Boolean deliveryStatus;

    private AddressDto sellerLocation;

    private OrderDto orderDto;

    private SellerDto sellerDto;

    private  TransactionDto transactionDto;
}

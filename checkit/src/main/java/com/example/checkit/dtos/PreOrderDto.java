package com.example.checkit.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PreOrderDto {

    private Long id;

    @NotBlank(message = "client Name should be empty")
    private String clientName;

    @NotBlank(message = "client number should be empty")
    private String clientPhoneNumber;

    private Float tripDistance;

    private Float deliveryCost;

    private Float totalCost;

    private AddressDto clientAddressDto;



}

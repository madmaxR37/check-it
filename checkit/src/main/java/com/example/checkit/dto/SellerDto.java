package com.example.checkit.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SellerDto extends UserDto {

    private List<String> nationalId;

    private List<ItemDto> itemDtos;

    private List<OrderDto> orderDtos;

    private List<TransactionDto> transactionDtos;

    private List<DeliveryDto> deliveries;
}

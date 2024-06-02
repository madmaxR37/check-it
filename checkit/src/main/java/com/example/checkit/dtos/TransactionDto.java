package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TransactionDto {


    protected Long id;


    protected Float amount;


    protected Boolean status;


    private LocalDateTime createdDate;


    protected PreOrderDto preOrderDto;


    protected DeliveryDto deliveryDto;


}

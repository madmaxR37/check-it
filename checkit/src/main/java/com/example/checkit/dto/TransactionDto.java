package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@Accessors(chain = true)
public class TransactionDto {

    protected Long id;

    protected Float amount;

    protected Date date;

    protected Boolean status;

    private Date createdDate;

    protected PreOrderDto preOrderDto;

    protected DeliveryDto deliveryDto;


}

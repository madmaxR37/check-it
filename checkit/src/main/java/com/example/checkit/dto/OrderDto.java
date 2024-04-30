package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderDto {

    private Long id;

    private Boolean status;

    private Date createdDate;

    private TransactionDto transactionDto;

    private PreOrderDto preOrderDto;

}

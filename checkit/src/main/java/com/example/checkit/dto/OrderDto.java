package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class OrderDto {

    private Integer id;

    private Boolean status;

    private Date date;

    private TransactionDto transactionDto;

}

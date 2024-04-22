package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Data
@Accessors(chain = true)
public class TransactionDto {

    protected Integer id;

    protected Float amount;

    protected Date date;

    protected Boolean status;

    protected PreOrderDto preOrderDto;


}

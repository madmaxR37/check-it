package com.example.checkit.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class CreditCardDto extends TransactionDto {

    private String creditCartNumber;

    private String cvv;

    private String date;
}

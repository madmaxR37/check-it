package com.example.checkit.dtos;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MobileDto extends TransactionDto {

    @Min(value = 9 , message = "enter a valid number")
    private String number;
}

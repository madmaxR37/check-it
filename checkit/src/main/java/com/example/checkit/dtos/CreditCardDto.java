package com.example.checkit.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.CreditCardNumber;


@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class CreditCardDto extends TransactionDto {

    @CreditCardNumber(message = "please enter a valid credit card number")
    private String creditCartNumber;

    @Size(max = 4, min = 3, message = "cvv must contain at least 3 digits and 4 at most")
    private String cvv;

    private String expDate;
}

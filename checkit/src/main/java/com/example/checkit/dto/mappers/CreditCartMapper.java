package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CreditCartDto;
import com.example.checkit.model.CreditCart;

public class CreditCartMapper {

    public static CreditCart creditCartDtoToCreditCart(CreditCartDto creditCartDto){
        return (CreditCart) new  CreditCart()
                .setCreditCartNumber(creditCartDto.getCreditCartNumber())
                .setCvv(creditCartDto.getCvv())
                .setAmount(creditCartDto.getAmount())
                .setStatus(creditCartDto.getStatus())
                ;
    }

    public static CreditCartDto creditCartToCreditCartDto(CreditCart creditCart){
        return (CreditCartDto) new CreditCartDto()
                .setCreditCartNumber(creditCart.getCreditCartNumber())
                .setCvv(creditCart.getCvv())
                .setAmount(creditCart.getAmount())
                .setStatus(creditCart.getStatus());

    }
    //TODO map preorder
}

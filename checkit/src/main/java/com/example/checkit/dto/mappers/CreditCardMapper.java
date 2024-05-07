package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CreditCardDto;
import com.example.checkit.model.CreditCard;

public class CreditCardMapper {

    public static CreditCard creditCartDtoToCreditCart(CreditCardDto creditCardDto){
        return (CreditCard) new CreditCard()
                .setCreditCartNumber(creditCardDto.getCreditCartNumber())
                .setCvv(creditCardDto.getCvv())
                .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(creditCardDto.getPreOrderDto()));
    }

    public static CreditCardDto creditCartToCreditCartDto(CreditCard creditCard){
        return (CreditCardDto) new CreditCardDto()
                .setCreditCartNumber(creditCard.getCreditCartNumber())
                .setCvv(creditCard.getCvv())
                .setAmount(creditCard.getAmount())
                .setStatus(creditCard.getStatus())
                .setId(creditCard.getId())
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(creditCard.getPreOrder()));

    }
}

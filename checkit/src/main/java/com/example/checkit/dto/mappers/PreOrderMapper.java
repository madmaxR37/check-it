package com.example.checkit.dto.mappers;

import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.model.PreOrder;

public class PreOrderMapper {

    public static PreOrder preOrderDtoToPreOrder(PreOrderDto preOrderDto){
        return new PreOrder()
                .setClientName(preOrderDto.getClientName())
                .setClientPhoneNumber(preOrderDto.getClientPhoneNumber())
                .setClientAddress(AddressMapper.addressDtoToAddress(preOrderDto.getClientAddressDto()))
                .setCard(CardMapper.cardDtoToCard(preOrderDto.getCardDto()));
    }

    public static PreOrderDto preOrderToPreOrder(PreOrder preOrder){
        return new PreOrderDto()
                .setId(preOrder.getId())
                .setTotalCost(preOrder.getTotalCost())
                .setClientName(preOrder.getClientName())
                .setDeliveryCost(preOrder.getDeliveryCost())
                .setClientPhoneNumber(preOrder.getClientPhoneNumber())
                .setTripDistance(preOrder.getTripDistance())
                .setCardDto(CardMapper.cardToCardDto(preOrder.getCard()));
    }
}

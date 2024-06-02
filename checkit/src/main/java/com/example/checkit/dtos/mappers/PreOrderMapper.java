package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.PreOrderDto;
import com.example.checkit.models.PreOrder;

public class PreOrderMapper {

    public static PreOrder preOrderDtoToPreOrder(PreOrderDto preOrderDto){
        return new PreOrder()
                .setClientName(preOrderDto.getClientName())
                .setClientPhoneNumber(preOrderDto.getClientPhoneNumber())
                .setClientAddress(AddressMapper.addressDtoToAddress(preOrderDto.getClientAddressDto()));
    }

    public static PreOrderDto preOrderToPreOrder(PreOrder preOrder){
        return new PreOrderDto()
                .setId(preOrder.getId())
                .setTotalCost(preOrder.getTotalCost())
                .setClientName(preOrder.getClientName())
                .setDeliveryCost(preOrder.getDeliveryCost())
                .setClientPhoneNumber(preOrder.getClientPhoneNumber())
                .setTripDistance(preOrder.getTripDistance())
                .setClientAddressDto(AddressMapper.addressToAddressDto(preOrder.getClientAddress()));
    }
}

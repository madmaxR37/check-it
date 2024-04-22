package com.example.checkit.dto.mappers;

import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.model.PreOrder;

public class PreOrderMapper {

    public static PreOrder preOrderDtoToPreOrder(PreOrderDto preOrderDto){
        return new PreOrder()
                .setTotalCost(preOrderDto.getTotalCost())
                .setClientName(preOrderDto.getClientName())
                .setDeliveryCost(preOrderDto.getDeliveryCost())
                .setClientPhoneNumber(preOrderDto.getClientPhoneNumber())
                .setTripDistance(preOrderDto.getTripDistance())
                ;
    }

    public static PreOrderDto preOrderToPreOrder(PreOrder preOrder){
        return new PreOrderDto()
                .setId(preOrder.getId())
                .setTotalCost(preOrder.getTotalCost())
                .setClientName(preOrder.getClientName())
                .setDeliveryCost(preOrder.getDeliveryCost())
                .setClientPhoneNumber(preOrder.getClientPhoneNumber())
                .setTripDistance(preOrder.getTripDistance())
                ;
    }
    //TODO map the rest of the entities
}

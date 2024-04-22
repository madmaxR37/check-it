package com.example.checkit.dto.mappers;

import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.model.Delivery;

public class DeliveryMapper {

    public static Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto){
        return new Delivery()
                .setDeliveryTitle(deliveryDto.getDeliveryTitle())
                .setDeliveryCost(deliveryDto.getDeliveryCost())
                .setDeliveryStatus(deliveryDto.getDeliveryStatus())
                .setAcceptanceStatus(deliveryDto.getAcceptanceStatus())
                .setDescription(deliveryDto.getDescription())
                .setSellerPhoneNumber(deliveryDto.getSellerPhoneNumber())
                ;
    }

    public static DeliveryDto deliveryToDeliveryDto(Delivery delivery){

        return new DeliveryDto()
                .setDeliveryTitle(delivery.getDeliveryTitle())
                .setDeliveryCost(delivery.getDeliveryCost())
                .setDeliveryStatus(delivery.getDeliveryStatus())
                .setAcceptanceStatus(delivery.getAcceptanceStatus())
                .setDescription(delivery.getDescription())
                .setSellerPhoneNumber(delivery.getSellerPhoneNumber());
    }

    //TODO map the rest of the fields
}

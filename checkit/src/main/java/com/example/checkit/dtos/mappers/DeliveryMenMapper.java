package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.DeliveryMenDto;
import com.example.checkit.models.DeliveryMen;

public class DeliveryMenMapper {
    public static DeliveryMen deliveryDtoToDeliveryMen(DeliveryMenDto deliveryMenDto){
        return new DeliveryMen()
                .setDeliveryMEN(deliveryMenDto.getDeliveryMEN())
                .setSeller(deliveryMenDto.getSeller());
    }
    public static  DeliveryMenDto deliveryMenToDeliveryMenDto(DeliveryMen deliveryMen){
        return new DeliveryMenDto()
                .setDeliveryMEN(deliveryMen.getDeliveryMEN())
                .setId(deliveryMen.getId())
                .setSeller(deliveryMen.getSeller());

    }
}

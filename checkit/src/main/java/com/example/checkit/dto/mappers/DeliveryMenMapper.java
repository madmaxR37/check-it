package com.example.checkit.dto.mappers;

import com.example.checkit.dto.DeliveryMenDto;
import com.example.checkit.model.DeliveryMen;

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

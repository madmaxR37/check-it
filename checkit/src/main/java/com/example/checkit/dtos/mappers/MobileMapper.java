package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.MobileDto;
import com.example.checkit.models.Mobile;

public class MobileMapper {

    public static Mobile mobileDtoToMobile(MobileDto mobileDto){
        return  new Mobile()
                .setNumber(mobileDto.getNumber());
    }

    public static MobileDto mobileToMobileDto(Mobile mobile){
        return (MobileDto) new MobileDto()
                .setNumber(mobile.getNumber())
                .setAmount(mobile.getAmount())
                .setStatus(mobile.getStatus())
                .setId(mobile.getId())
                .setCreatedDate(mobile.getCreatedDate())
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(mobile.getPreOrder()));
    }
}

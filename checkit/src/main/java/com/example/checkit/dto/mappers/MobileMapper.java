package com.example.checkit.dto.mappers;

import com.example.checkit.dto.MobileDto;
import com.example.checkit.model.Mobile;

public class MobileMapper {

    public static Mobile mobileDtoToMobile(MobileDto mobileDto){
        return (Mobile) new Mobile()
                .setNumber(mobileDto.getNumber())
                .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(mobileDto.getPreOrderDto()));
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

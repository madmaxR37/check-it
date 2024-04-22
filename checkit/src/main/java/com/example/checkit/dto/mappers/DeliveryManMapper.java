package com.example.checkit.dto.mappers;

import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.model.DeliveryMan;


public class DeliveryManMapper {

    public static DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto){

        return (DeliveryMan) new DeliveryMan()
                .setNicImagesUrls(deliveryManDto.getNicImagesUrls())
                .setDrivingLicenseUrls(deliveryManDto.getDrivingLicenseUrls())
                .setFirstname(deliveryManDto.getFirstname())
                .setSurname(deliveryManDto.getSurname())
                .setPhoneNumber(deliveryManDto.getPhoneNumber())
                .setActiveStatus(deliveryManDto.getActiveStatus())
                .setAccountBalance(deliveryManDto.getAccountBalance())
                .setRole(deliveryManDto.getRole())
                .setProfileUrl(deliveryManDto.getProfileUrl());
    }

    public static DeliveryManDto deliveryManTODeliveryManDto(DeliveryMan deliveryMan){
        return (DeliveryManDto) new DeliveryManDto()
                .setNicImagesUrls(deliveryMan.getNicImagesUrls())
                .setDrivingLicenseUrls(deliveryMan.getDrivingLicenseUrls())
                .setFirstname(deliveryMan.getFirstname())
                .setSurname(deliveryMan.getSurname())
                .setPhoneNumber(deliveryMan.getPhoneNumber())
                .setActiveStatus(deliveryMan.getActiveStatus())
                .setAccountBalance(deliveryMan.getAccountBalance())
                .setRole(deliveryMan.getRole())
                .setProfileUrl(deliveryMan.getProfileUrl())
                ;
    }
    //TODO map the rest of the fields
}

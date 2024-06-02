package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.DeliveryManDto;
import com.example.checkit.models.DeliveryMan;


public class DeliveryManMapper {

    public static DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto){

        return (DeliveryMan) new DeliveryMan()
                .setNicImagesUrls(deliveryManDto.getNicImagesUrls())
                .setDrivingLicenseUrls(deliveryManDto.getDrivingLicenseUrls())
                .setVehicle(VehicleMapper.vehicleDtoToVehicle(deliveryManDto.getVehicleDto()))
                .setFirstname(deliveryManDto.getFirstname())
                .setLast_name(deliveryManDto.getSurname())
                .setEmail(deliveryManDto.getEmail())
                .setPhoneNumber(deliveryManDto.getPhoneNumber())
                .setProfileUrl(deliveryManDto.getProfileUrl());
    }

    public static DeliveryManDto deliveryManTODeliveryManDto(DeliveryMan deliveryMan){
        return (DeliveryManDto) new DeliveryManDto()
                .setFirstname(deliveryMan.getFirstname())
                .setSurname(deliveryMan.getLast_name())
                .setEmail(deliveryMan.getEmail())
                .setId(deliveryMan.getId())
                .setPhoneNumber(deliveryMan.getPhoneNumber())
                .setActiveStatus(deliveryMan.getActiveStatus())
                .setAccountBalance(deliveryMan.getAccountBalance())
                .setRole(deliveryMan.getRole())
                .setProfileUrl(deliveryMan.getProfileUrl())
                .setCreatedDate(deliveryMan.getCreatedDate());
    }
}

package com.example.checkit.dto.mappers;

import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.model.DeliveryMan;


public class DeliveryManMapper {

    public static DeliveryMan deliveryManDtoToDeliveryMan(DeliveryManDto deliveryManDto){

        return (DeliveryMan) new DeliveryMan()
                .setNicImagesUrls(deliveryManDto.getNicImagesUrls())
                .setDrivingLicenseUrls(deliveryManDto.getDrivingLicenseUrls())
                .setVehicle(VehicleMapper.vehicleDtoToVehicle(deliveryManDto.getVehicleDto()))
                .setDeliveries(DeliveryMapper.deliveriesDtoToDeliveries(deliveryManDto.getDeliveries()))
                .setFirstname(deliveryManDto.getFirstname())
                .setSurname(deliveryManDto.getSurname())
                .setEmail(deliveryManDto.getEmail())
                .setPhoneNumber(deliveryManDto.getPhoneNumber())
                .setProfileUrl(deliveryManDto.getProfileUrl());
    }

    public static DeliveryManDto deliveryManTODeliveryManDto(DeliveryMan deliveryMan){
        return (DeliveryManDto) new DeliveryManDto()
                .setNicImagesUrls(deliveryMan.getNicImagesUrls())
                .setVehicleDto(VehicleMapper.vehicleToVehicleDto(deliveryMan.getVehicle()))
                .setDrivingLicenseUrls(deliveryMan.getDrivingLicenseUrls())
                .setFirstname(deliveryMan.getFirstname())
                .setSurname(deliveryMan.getSurname())
                .setEmail(deliveryMan.getEmail())
                .setId(deliveryMan.getId())
                .setPhoneNumber(deliveryMan.getPhoneNumber())
                .setActiveStatus(deliveryMan.getActiveStatus())
                .setAccountBalance(deliveryMan.getAccountBalance())
                .setRole(deliveryMan.getRole())
                .setProfileUrl(deliveryMan.getProfileUrl())
                .setCreatedDate(deliveryMan.getCreatedDate())
                ;
    }
}

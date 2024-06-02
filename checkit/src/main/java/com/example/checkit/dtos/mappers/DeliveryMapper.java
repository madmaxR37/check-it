package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.DeliveryDto;
import com.example.checkit.models.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryMapper {

    public static Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto){
        return new Delivery()
                .setDeliveryTitle(deliveryDto.getDeliveryTitle())
                .setDescription(deliveryDto.getDescription())
                .setAssignationStatus(deliveryDto.getAssignationStatus())
                .setSellerPhoneNumber(deliveryDto.getSellerPhoneNumber())
                .setSellerLocation(AddressMapper.addressDtoToAddress(deliveryDto.getSellerLocation()));
    }

    public static DeliveryDto deliveryToDeliveryDto(Delivery delivery){

        return new DeliveryDto()
                .setCreatedDate(delivery.getCreatedDate())
                .setAssignationStatus(delivery.getAssignationStatus())
                .setPaymentStatus(delivery.getPaymentStatus())
                .setDeliveryTitle(delivery.getDeliveryTitle())
                .setDeliveryCost(delivery.getDeliveryCost())
                .setId(delivery.getId())
                .setDeliveryStatus(delivery.getDeliveryStatus())
                .setAcceptanceStatus(delivery.getAcceptanceStatus())
                .setDescription(delivery.getDescription())
                .setSellerPhoneNumber(delivery.getSellerPhoneNumber())
                .setSellerDto(SellerMapper.sellerToSellerDto(delivery.getSeller()))
                .setSellerLocation(AddressMapper.addressToAddressDto(delivery.getSellerLocation()))
                .setOrderDto(OrderMapper.orderToOrderDto(delivery.getOrderEntity()));
    }

    public static List<Delivery> deliveriesDtoToDeliveries (List<DeliveryDto> deliveryDtos){
        List<Delivery> deliveries = new ArrayList<>();
        for (DeliveryDto deliveryDto: deliveryDtos){
           Delivery delivery = new Delivery()
                    .setDeliveryTitle(deliveryDto.getDeliveryTitle())
                    .setAssignationStatus(deliveryDto.getAssignationStatus())
                    .setDeliveryStatus(deliveryDto.getDeliveryStatus())
                    .setAcceptanceStatus(deliveryDto.getAcceptanceStatus())
                    .setDescription(deliveryDto.getDescription())
                    .setSellerPhoneNumber(deliveryDto.getSellerPhoneNumber())
                    .setSellerLocation(AddressMapper.addressDtoToAddress(deliveryDto.getSellerLocation()));
           deliveries.add(delivery);
        }
        return deliveries;
    }

    public static List<DeliveryDto> deliveriesToDeliveriesDto (List<Delivery> deliveries){

        List<DeliveryDto> deliveryDtos = new ArrayList<>();

        for (Delivery delivery: deliveries){
           DeliveryDto deliveryDto= new DeliveryDto()
                    .setId(delivery.getId())
                    .setPaymentStatus(delivery.getPaymentStatus())
                    .setCreatedDate(delivery.getCreatedDate())
                    .setAssignationStatus(delivery.getAssignationStatus())
                    .setDeliveryTitle(delivery.getDeliveryTitle())
                    .setDeliveryCost(delivery.getDeliveryCost())
                    .setDeliveryStatus(delivery.getDeliveryStatus())
                    .setAcceptanceStatus(delivery.getAcceptanceStatus())
                    .setDescription(delivery.getDescription())
                    .setSellerPhoneNumber(delivery.getSellerPhoneNumber())
                    .setSellerDto(SellerMapper.sellerToSellerDto(delivery.getSeller()))
                    .setSellerLocation(AddressMapper.addressToAddressDto(delivery.getSellerLocation()))
                    .setOrderDto(OrderMapper.orderToOrderDto(delivery.getOrderEntity()));
           deliveryDtos.add(deliveryDto);
        }
        return deliveryDtos;
    }

}

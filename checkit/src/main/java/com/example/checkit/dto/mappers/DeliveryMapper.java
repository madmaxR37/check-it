package com.example.checkit.dto.mappers;

import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.model.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryMapper {

    public static Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto){
        return new Delivery()
                .setDeliveryTitle(deliveryDto.getDeliveryTitle())
                .setDescription(deliveryDto.getDescription())
                .setAssignationStatus(deliveryDto.getAssignationStatus())
                .setSellerPhoneNumber(deliveryDto.getSellerPhoneNumber())
                .setOrder(OrderMapper.orderDtoToOrder(deliveryDto.getOrderDto()))
                .setSellerLocation(AddressMapper.addressDtoToAddress(deliveryDto.getSellerLocation()))
                .setDeliveryMan(DeliveryManMapper.deliveryManDtoToDeliveryMan(deliveryDto.getDeliveryManDto()))
                .setSeller(SellerMapper.sellerDtoToSeller(deliveryDto.getSellerDto()));
    }

    public static DeliveryDto deliveryToDeliveryDto(Delivery delivery){

        return new DeliveryDto()
                .setCreatedDate(delivery.getCreatedDate())
                .setAssignationStatus(delivery.getAssignationStatus())
                .setPaymentStatus(delivery.getPaymentStatus())
                .setDeliveryTitle(delivery.getDeliveryTitle())
                .setDeliveryCost(delivery.getDeliveryCost())
                .setId(delivery.getId())
                .setTransactionDto(TransactionMapper.transactionToTransactionDto(delivery.getTransaction()))
                .setDeliveryStatus(delivery.getDeliveryStatus())
                .setAcceptanceStatus(delivery.getAcceptanceStatus())
                .setDescription(delivery.getDescription())
                .setSellerPhoneNumber(delivery.getSellerPhoneNumber())
                .setSellerDto(SellerMapper.sellerToSellerDto(delivery.getSeller()))
                .setSellerLocation(AddressMapper.addressToAddressDto(delivery.getSellerLocation()))
                .setDeliveryManDto(DeliveryManMapper.deliveryManTODeliveryManDto(delivery.getDeliveryMan()))
                .setOrderDto(OrderMapper.orderToOrderDto(delivery.getOrder()));
    }

    public static List<Delivery> deliveriesDtoToDeliveries (List<DeliveryDto> deliveryDtos){
        List<Delivery> deliveries = new ArrayList<>();
        for (DeliveryDto deliveryDto: deliveryDtos){
           Delivery delivery = new Delivery()
                    .setDeliveryTitle(deliveryDto.getDeliveryTitle())
                    .setAssignationStatus(deliveryDto.getAssignationStatus())
                    .setDeliveryCost(deliveryDto.getDeliveryCost())
                    .setDeliveryStatus(deliveryDto.getDeliveryStatus())
                    .setAcceptanceStatus(deliveryDto.getAcceptanceStatus())
                    .setDescription(deliveryDto.getDescription())
                    .setSellerPhoneNumber(deliveryDto.getSellerPhoneNumber())
                    .setOrder(OrderMapper.orderDtoToOrder(deliveryDto.getOrderDto()))
                    .setSellerLocation(AddressMapper.addressDtoToAddress(deliveryDto.getSellerLocation()))
                    .setDeliveryMan(DeliveryManMapper.deliveryManDtoToDeliveryMan(deliveryDto.getDeliveryManDto()))
                    .setSeller(SellerMapper.sellerDtoToSeller(deliveryDto.getSellerDto()));
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
                    .setDeliveryManDto(DeliveryManMapper.deliveryManTODeliveryManDto(delivery.getDeliveryMan()))
                    .setOrderDto(OrderMapper.orderToOrderDto(delivery.getOrder()));
           deliveryDtos.add(deliveryDto);
        }
        return deliveryDtos;
    }

}

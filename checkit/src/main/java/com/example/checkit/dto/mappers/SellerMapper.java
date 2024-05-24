package com.example.checkit.dto.mappers;

import com.example.checkit.dto.SellerDto;
import com.example.checkit.model.Seller;

public class SellerMapper {

    public static Seller sellerDtoToSeller(SellerDto sellerDto){
        return (Seller) new Seller()
                .setNationalId(sellerDto.getNationalId())
                .setOrders(OrderMapper.ordersDtoToOrders(sellerDto.getOrderDtos()))
                .setItems(ItemMapper.itemsDtoToItems(sellerDto.getItemDtos()))
                .setTransactions(TransactionMapper.transactionsDtoToTransactions(sellerDto.getTransactionDtos()))
                .setDeliveries(DeliveryMapper.deliveriesDtoToDeliveries(sellerDto.getDeliveries()))
                .setFirstname(sellerDto.getFirstname())
                .setSurname(sellerDto.getSurname())
                .setPhoneNumber(sellerDto.getPhoneNumber())
                .setEmail(sellerDto.getEmail())
                .setPassword(sellerDto.getPassword())
                .setActiveStatus(sellerDto.getActiveStatus())
                .setAccountBalance(sellerDto.getAccountBalance())
                .setRole(sellerDto.getRole())
                .setProfileUrl(sellerDto.getProfileUrl());
    }

    public static SellerDto sellerToSellerDto(Seller seller){

        return (SellerDto) new SellerDto()
                .setNationalId(seller.getNationalId())
                .setItemDtos(ItemMapper.itemsToItemsDto(seller.getItems()))
                .setOrderDtos(OrderMapper.ordersToOrdersDto(seller.getOrders()))
                .setTransactionDtos(TransactionMapper.transactionsToTransactionsDto(seller.getTransactions()))
                .setDeliveries(DeliveryMapper.deliveriesToDeliveriesDto(seller.getDeliveries()))
                .setFirstname(seller.getFirstname())
                .setSurname(seller.getSurname())
                .setEmail(seller.getEmail())
                .setPhoneNumber(seller.getPhoneNumber())
                .setActiveStatus(seller.getActiveStatus())
                .setAccountBalance(seller.getAccountBalance())
                .setRole(seller.getRole())
                .setProfileUrl(seller.getProfileUrl())
                .setCreatedDate(seller.getCreatedDate());
    }
}

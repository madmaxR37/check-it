package com.example.checkit.dto.mappers;

import com.example.checkit.dto.SellerDto;
import com.example.checkit.model.Seller;

public class SellerMapper {

    public static Seller sellerDtoToSeller(SellerDto sellerDto){
        return (Seller) new Seller()
                .setNationalId(sellerDto.getNationalId())
                .setFirstname(sellerDto.getFirstname())
                .setSurname(sellerDto.getSurname())
                .setPhoneNumber(sellerDto.getPhoneNumber())
                .setActiveStatus(sellerDto.getActiveStatus())
                .setAccountBalance(sellerDto.getAccountBalance())
                .setRole(sellerDto.getRole())
                .setProfileUrl(sellerDto.getProfileUrl());
    }

    public static SellerDto sellerToSellerDto(Seller seller){

        return (SellerDto) new SellerDto()
                .setNationalId(seller.getNationalId())
                .setFirstname(seller.getFirstname())
                .setSurname(seller.getSurname())
                .setPhoneNumber(seller.getPhoneNumber())
                .setActiveStatus(seller.getActiveStatus())
                .setAccountBalance(seller.getAccountBalance())
                .setRole(seller.getRole())
                .setProfileUrl(seller.getProfileUrl());
    }
}

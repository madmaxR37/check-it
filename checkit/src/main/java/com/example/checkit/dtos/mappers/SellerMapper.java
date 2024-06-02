package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.SellerDto;
import com.example.checkit.models.Seller;

public class SellerMapper {

    public static Seller sellerDtoToSeller(SellerDto sellerDto) {
        return (Seller) new Seller()
                .setNationalId(sellerDto.getNationalId())
                .setFirstname(sellerDto.getFirstname())
                .setLast_name(sellerDto.getSurname())
                .setPhoneNumber(sellerDto.getPhoneNumber())
                .setEmail(sellerDto.getEmail())
                .setActiveStatus(sellerDto.getActiveStatus())
                .setAccountBalance(sellerDto.getAccountBalance())
                .setRole(sellerDto.getRole())
                .setProfileUrl(sellerDto.getProfileUrl())
                .setAddress(AddressMapper.addressDtoToAddress(sellerDto.getAddressDto()));
    }

    public static SellerDto sellerToSellerDto(Seller seller) {

        return (SellerDto) new SellerDto()
                .setNationalId(seller.getNationalId())
                .setFirstname(seller.getFirstname())
                .setSurname(seller.getLast_name())
                .setId(seller.getId())
                .setEmail(seller.getEmail())
                .setPhoneNumber(seller.getPhoneNumber())
                .setAccountBalance(seller.getAccountBalance())
                .setProfileUrl(seller.getProfileUrl())
                .setActiveStatus(seller.getActiveStatus())
                .setRole(seller.getRole())
                .setAddressDto(AddressMapper.addressToAddressDto(seller.getAddress()));

    }
}
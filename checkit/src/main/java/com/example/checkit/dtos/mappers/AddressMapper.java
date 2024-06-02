package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.AddressDto;
import com.example.checkit.models.Address;

public class AddressMapper {

    public static AddressDto addressToAddressDto(Address address){
        return new AddressDto()
                .setAddressName(address.getAddressName())
                .setAddressLatitude(address.getAddressLatitude())
                .setAddressLongitude(address.getAddressLongitude());
    }

    public static Address addressDtoToAddress(AddressDto addressDto){
        return new Address()
                .setAddressName(addressDto.getAddressName())
                .setAddressLatitude(addressDto.getAddressLatitude())
                .setAddressLongitude(addressDto.getAddressLongitude());
    }
}

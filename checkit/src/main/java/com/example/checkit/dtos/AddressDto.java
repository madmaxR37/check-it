package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressDto {

    protected String addressName;

    protected  Long addressLongitude;

    protected Long addressLatitude;
}

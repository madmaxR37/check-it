package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class AddressDto {

    protected String addressName;

    protected BigDecimal addressLongitude;

    protected BigDecimal addressLatitude;
}

package com.example.checkit.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AddressDto {

    protected String addressName;

    protected  Long addressLongitude;

    protected Long addressLatitude;
}

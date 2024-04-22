package com.example.checkit.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.experimental.Accessors;

@Embeddable
@Data
@Accessors(chain = true)
public class Address {

    protected String addressName;

    protected  Long addressLongitude;

    protected Long addressLatitude;
}

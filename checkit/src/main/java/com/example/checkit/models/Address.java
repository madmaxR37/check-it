package com.example.checkit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Embeddable
@Data
@Accessors(chain = true)
public class Address {

    protected String addressName;

    @Column(precision = 24, scale = 17, nullable = false)
    protected BigDecimal addressLongitude;

    @Column(precision = 24, scale = 17, nullable = false)
    protected BigDecimal addressLatitude;
}

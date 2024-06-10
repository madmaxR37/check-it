package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OfferDto {

    private Long id;

    private String Client;

    private String ClientProfile;

    private Boolean status;

    private Float initialPrice;

    private Float offerValue;

    private CartDto cartDto;
}

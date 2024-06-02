package com.example.checkit.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CartDto {

    private Long id;

    @NotBlank(message = "cart must have a name")
    private String name;

    private Boolean isActiveStatus;

    private Integer totalItemsQuantity;

    private Float totalItemsCost;

    private List<PurchaseLineDto> purchaseLineDto;

}

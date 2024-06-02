package com.example.checkit.dtos;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PurchaseLineDto {
    
    private Long id;

    @Min(value = 1, message = "quantity should be greater than 1")
    private Integer quantity;
    
    private Float price;

    private ItemDto itemDto;
}

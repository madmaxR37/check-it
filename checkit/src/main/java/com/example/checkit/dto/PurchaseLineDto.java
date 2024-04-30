package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PurchaseLineDto {
    
    private Long id;
    
    private Integer quantity;
    
    private Float price;

    private ItemDto itemDto;
}

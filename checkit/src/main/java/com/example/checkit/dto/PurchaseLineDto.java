package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PurchaseLineDto {
    
    private Integer id;
    
    private Integer quantity;
    
    private Float price;
}

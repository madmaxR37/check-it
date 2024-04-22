package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ItemDto {

    private Integer id;

    private String itemName;

    private Integer quantity;

    private Float unitPrice;

    private String itemDescription;

    private List<String> itemImages;

    private Boolean availableStatus;

    private SellerDto sellerDto;

    private List<CategoryDto> categories;


}

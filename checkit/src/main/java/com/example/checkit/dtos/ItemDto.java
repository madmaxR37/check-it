package com.example.checkit.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class ItemDto {

    private Long id;

    @NotBlank(message = "item must have a name")
    private String itemName;

    private LocalDateTime createdDate;

    @Min(value = 100, message = "item unit price should be at least 100 ")
    private Float unitPrice;

    @NotBlank(message = "item must have a description")
    private String itemDescription;

    @NotEmpty(message = "you must add at least an image")
    private List<String> itemImages;

    private Boolean availableStatus;

    private SellerDto sellerDto;

    private List<CategoryDto> categories;


}

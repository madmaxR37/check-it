package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CategoryDto {

    private Integer id;


    private String name;


    private Boolean isActive;


    private List<ItemDto> itemDtos;
}

package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VehicleDto {

    private Integer id;

    private String brand;

    private String matriculation;

    private VehicleCategoryDto vehicleCategoryDto;
}


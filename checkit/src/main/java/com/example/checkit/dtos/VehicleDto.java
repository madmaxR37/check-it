package com.example.checkit.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VehicleDto {

    private Long id;

    @NotBlank(message = "vehicle name must be specified")
    private String brand;

    @NotBlank(message = "vehicle matriculation must be specified")
    private String matriculation;

    private VehicleCategoryDto vehicleCategoryDto;
}


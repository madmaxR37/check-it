package com.example.checkit.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VehicleCategoryDto {

    private Long id;

    @NotBlank(message = "brand must be specified")
    private String name;

    private Boolean isActive;

    private String svgUrl ;


}

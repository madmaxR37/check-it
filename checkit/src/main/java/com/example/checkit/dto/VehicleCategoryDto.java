package com.example.checkit.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class VehicleCategoryDto {

    private Long id;

    private String name;

    private Boolean isActive;

    private String svgUrl ;


}

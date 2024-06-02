package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.VehicleCategoryDto;
import com.example.checkit.models.VehicleCategory;

public class VehicleCategoryMapper {

    public static VehicleCategory vehicleCategoryDtoToVehicleCategory(VehicleCategoryDto vehicleCategoryDto){
        return new VehicleCategory()
                .setName(vehicleCategoryDto.getName())
                .setIsActive(vehicleCategoryDto.getIsActive())
                .setSvgUrl(vehicleCategoryDto.getSvgUrl());
    }

    public static VehicleCategoryDto vehicleCategoryToVehicleCategoryDto(VehicleCategory vehicleCategory){
        return new VehicleCategoryDto()
                .setId(vehicleCategory.getId())
                .setId(vehicleCategory.getId())
                .setName(vehicleCategory.getName())
                .setIsActive(vehicleCategory.getIsActive())
                .setSvgUrl(vehicleCategory.getSvgUrl());
    }
}

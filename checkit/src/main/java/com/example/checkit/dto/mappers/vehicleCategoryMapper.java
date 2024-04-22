package com.example.checkit.dto.mappers;

import com.example.checkit.dto.VehicleCategoryDto;
import com.example.checkit.model.VehicleCategory;

public class vehicleCategoryMapper {

    public static VehicleCategory vehicleCategoryDtoToVehicleCategory(VehicleCategoryDto vehicleCategoryDto){
        return new VehicleCategory()
                .setName(vehicleCategoryDto.getName())
                .setIsActive(vehicleCategoryDto.getIsActive())
                .setSvgUrl(vehicleCategoryDto.getSvgUrl());
    }

    public static VehicleCategoryDto vehicleCategoryToVehicleCategoryDto(VehicleCategory vehicleCategory){
        return new VehicleCategoryDto()
                .setId(vehicleCategory.getId())
                .setName(vehicleCategory.getName())
                .setIsActive(vehicleCategory.getIsActive())
                .setSvgUrl(vehicleCategory.getSvgUrl());
    }
}

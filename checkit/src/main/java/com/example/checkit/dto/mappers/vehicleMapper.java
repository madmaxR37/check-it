package com.example.checkit.dto.mappers;

import com.example.checkit.dto.VehicleDto;
import com.example.checkit.model.Vehicle;

public class VehicleMapper {

    public static Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto){
        return new Vehicle()
                .setBrand(vehicleDto.getBrand())
                .setMatriculation(vehicleDto.getMatriculation())
                .setVehicleCategory(VehicleCategoryMapper.vehicleCategoryDtoToVehicleCategory(vehicleDto.getVehicleCategoryDto()));
    }

    public static VehicleDto vehicleToVehicleDto(Vehicle vehicle){
        return new VehicleDto()
                .setId(vehicle.getId())
                .setBrand(vehicle.getBrand())
                .setMatriculation(vehicle.getMatriculation())
                .setVehicleCategoryDto(VehicleCategoryMapper.vehicleCategoryToVehicleCategoryDto(vehicle.getVehicleCategory()));
    }
}

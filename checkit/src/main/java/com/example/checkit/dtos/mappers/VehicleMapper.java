package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.VehicleDto;
import com.example.checkit.models.Vehicle;

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

package com.example.checkit.dto.mappers;

import com.example.checkit.dto.VehicleDto;
import com.example.checkit.model.Vehicle;

public class vehicleMapper {

    public static Vehicle vehicleDtoToVehicle(VehicleDto vehicleDto){
        return new Vehicle()
                .setBrand(vehicleDto.getBrand())
                .setMatriculation(vehicleDto.getMatriculation());
    }

    public static VehicleDto vehicleToVehicleDto(Vehicle vehicle){
        return new VehicleDto()
                .setBrand(vehicle.getBrand())
                .setMatriculation(vehicle.getMatriculation());
    }
}

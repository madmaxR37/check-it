package com.example.checkit.services;

import com.example.checkit.dtos.VehicleCategoryDto;

import java.util.List;

public interface VehicleCategoryService {

    VehicleCategoryDto createVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    List<VehicleCategoryDto> findAllVehicleCategories();

    void deleteVehicleCategory(Long id);
}

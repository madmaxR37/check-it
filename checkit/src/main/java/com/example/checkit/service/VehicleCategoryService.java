package com.example.checkit.service;

import com.example.checkit.dto.VehicleCategoryDto;

import java.util.List;

public interface VehicleCategoryService {

    VehicleCategoryDto createVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto);

    List<VehicleCategoryDto> findAllVehicleCategories();

    void deleteVehicleCategory(Long id);
}

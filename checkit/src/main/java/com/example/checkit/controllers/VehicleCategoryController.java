package com.example.checkit.controllers;

import com.example.checkit.dto.VehicleCategoryDto;
import com.example.checkit.service.serviceImplementation.VehicleCategoryServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/vehicle-category")
public class VehicleCategoryController {

    private final VehicleCategoryServiceImp vehicleCategoryServiceImp;

    public VehicleCategoryController(VehicleCategoryServiceImp vehicleCategoryServiceImp) {
        this.vehicleCategoryServiceImp = vehicleCategoryServiceImp;
    }

    @PostMapping("/save")
    public VehicleCategoryDto createVehicleCategory(@RequestBody VehicleCategoryDto vehicleCategoryDto){
        return vehicleCategoryServiceImp.createVehicleCategory(vehicleCategoryDto);
    }
}

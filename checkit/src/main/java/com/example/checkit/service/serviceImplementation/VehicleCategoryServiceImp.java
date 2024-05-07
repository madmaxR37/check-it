package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.VehicleCategoryDto;
import com.example.checkit.dto.mappers.VehicleCategoryMapper;
import com.example.checkit.repository.VehicleCategoryRepository;
import com.example.checkit.service.VehicleCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleCategoryServiceImp implements VehicleCategoryService {

    private final VehicleCategoryRepository categoryRepository;

    public VehicleCategoryServiceImp(VehicleCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public VehicleCategoryDto createVehicleCategory(VehicleCategoryDto vehicleCategoryDto) {
        return VehicleCategoryMapper
                .vehicleCategoryToVehicleCategoryDto(categoryRepository.save(VehicleCategoryMapper
                        .vehicleCategoryDtoToVehicleCategory(vehicleCategoryDto)));
    }

    @Override
    public VehicleCategoryDto updateVehicleCategory(VehicleCategoryDto vehicleCategoryDto) {
        return null;
    }

    @Override
    public List<VehicleCategoryDto> findAllVehicleCategories() {
        return null;
    }

    @Override
    public void deleteVehicleCategory(Long id) {

    }
}

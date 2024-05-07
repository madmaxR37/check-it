package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.DeliveryManDto;
import com.example.checkit.dto.VehicleDto;
import com.example.checkit.dto.mappers.DeliveryManMapper;
import com.example.checkit.dto.mappers.VehicleMapper;
import com.example.checkit.model.DeliveryMan;
import com.example.checkit.repository.DeliveryManRepository;
import com.example.checkit.repository.VehicleRepository;
import com.example.checkit.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryManServiceImp implements DeliveryManService {


    private final DeliveryManRepository deliveryManRepository;
    private final VehicleRepository vehicleRepository;

    public DeliveryManServiceImp(DeliveryManRepository deliveryManRepository,
                                 VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.deliveryManRepository=deliveryManRepository;
    }

    @Override
    public DeliveryManDto create(DeliveryManDto dto) {
        vehicleRepository.save(VehicleMapper.vehicleDtoToVehicle(dto.getVehicleDto()));
        DeliveryMan deliveryMan = deliveryManRepository.save(DeliveryManMapper.deliveryManDtoToDeliveryMan(dto));
        return DeliveryManMapper.deliveryManTODeliveryManDto(deliveryMan);
    }

    @Override
    public List<DeliveryManDto> findAll() {
        return null;
    }

    @Override
    public DeliveryManDto findByEmail(String email) {
        return null;
    }

    @Override
    public DeliveryManDto findById(Long id) {
        return null;
    }

    @Override
    public DeliveryManDto update(DeliveryManDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

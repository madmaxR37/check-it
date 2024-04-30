package com.example.checkit.service;

import com.example.checkit.dto.DeliveryManDto;

import java.util.List;

public interface DeliveryManService {

    DeliveryManDto create(DeliveryManDto dto);

    List<DeliveryManDto> findAll();

    DeliveryManDto findByEmail(String email);

    DeliveryManDto findById(Long id);

    DeliveryManDto update (DeliveryManDto dto);

    void delete(Long id);
}

package com.example.checkit.service;

import com.example.checkit.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    DeliveryDto createDelivery(DeliveryDto dto);

    DeliveryDto update(DeliveryDto dto);

    List<DeliveryDto> findAllByDeliveryManId(Long id);

    List<DeliveryDto> findAllByClientId(Long id);

    List<DeliveryDto> findAllBySellerId(Long id);

    void deleteDelivery(Long id);

}

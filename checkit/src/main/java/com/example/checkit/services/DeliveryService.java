package com.example.checkit.services;

import com.example.checkit.dtos.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    DeliveryDto createDelivery(DeliveryDto dto, Long orderI, Long sellerId);

    DeliveryDto update(DeliveryDto dto);

    List<DeliveryDto> findAllByDeliveryManId(Long id);

    List<DeliveryDto> findAllByClientId(Long id);

    List<DeliveryDto> findAllBySellerId(Long id);

    void deleteDelivery(Long id);

}

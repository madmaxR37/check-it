package com.example.checkit.services;


import com.example.checkit.dtos.PreOrderDto;

import java.util.List;

public interface PreOrderService {

    PreOrderDto createPreOrder(PreOrderDto preOrderDto,Long cartId);

    PreOrderDto findOrderById(Long id);

    PreOrderDto updateOrder(PreOrderDto orderDto);

    List<PreOrderDto> findAllOrders();

    void delete(Long id);
}

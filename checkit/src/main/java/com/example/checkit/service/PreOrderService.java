package com.example.checkit.service;


import com.example.checkit.dto.PreOrderDto;

import java.util.List;

public interface PreOrderService {

    PreOrderDto createPreOrder(PreOrderDto preOrderDto,Long cartId);

    PreOrderDto findOrderById(Long id);

    PreOrderDto updateOrder(PreOrderDto orderDto);

    List<PreOrderDto> findAllOrders();

    void delete(Long id);
}

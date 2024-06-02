package com.example.checkit.services;

import com.example.checkit.dtos.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto findOrderById(Long id);

    OrderDto updateOrder(OrderDto orderDto);

    List<OrderDto> findAllOrders();

    void delete(Long id);
}

package com.example.checkit.service;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.dto.TransactionDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(TransactionDto transactionDto);

    OrderDto findOrderById(Long id);

    OrderDto updateOrder(OrderDto orderDto);

    List<OrderDto> findAllOrders();

    void delete(Long id);
}

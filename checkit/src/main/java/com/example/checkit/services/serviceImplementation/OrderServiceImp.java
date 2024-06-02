package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.OrderDto;
import com.example.checkit.repositories.OrderRepository;
import com.example.checkit.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto findOrderById(Long id) {
        return null;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

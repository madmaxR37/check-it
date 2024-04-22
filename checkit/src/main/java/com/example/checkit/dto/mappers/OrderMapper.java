package com.example.checkit.dto.mappers;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.model.Order;

public class OrderMapper {

    public static Order orderDtoToOrder(OrderDto orderDto){
        return new Order()
                .setStatus(orderDto.getStatus());
    }

    public static OrderDto orderToOrderDto(Order order){
        return new OrderDto()
                .setId(order.getId())
                .setStatus(order.getStatus())
                .setDate(order.getDate());
    }
}

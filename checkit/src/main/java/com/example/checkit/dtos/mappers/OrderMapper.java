package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.OrderDto;
import com.example.checkit.models.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderEntity orderDtoToOrder(OrderDto orderDto){
        return new OrderEntity()
                .setStatus(orderDto.getStatus())
                .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(orderDto.getPreOrderDto()));
    }

    public static OrderDto orderToOrderDto(OrderEntity orderEntity){
        return new OrderDto()
                .setId(orderEntity.getId())
                .setStatus(orderEntity.getStatus())
                .setCreatedDate(orderEntity.getCreatedDate())
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(orderEntity.getPreOrder()));
    }

    public static List<OrderEntity> ordersDtoToOrders(List<OrderDto> orderDtos){
        List<OrderEntity> orderEntities = new ArrayList<>();

        for (OrderDto orderDto: orderDtos){
            OrderEntity orderEntity = new OrderEntity()
                    .setStatus(orderDto.getStatus())
                    .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(orderDto.getPreOrderDto()));
            orderEntities.add(orderEntity);
        }


        return orderEntities;
    }

    public static List<OrderDto> ordersToOrdersDto(List<OrderEntity> orderEntities){

        List<OrderDto> orderDtos = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities){
            OrderDto orderDto = new OrderDto()
                    .setCreatedDate(orderEntity.getCreatedDate())
                    .setId(orderEntity.getId())
                    .setStatus(orderEntity.getStatus())
                    .setCreatedDate(orderEntity.getCreatedDate())
                    .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(orderEntity.getPreOrder()));
            orderDtos.add(orderDto);
        }


        return  orderDtos;

    }
}

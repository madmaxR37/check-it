package com.example.checkit.dto.mappers;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order orderDtoToOrder(OrderDto orderDto){
        return new Order()
                .setStatus(orderDto.getStatus())
                .setTransaction(TransactionMapper.transactionDtoToTransaction(orderDto.getTransactionDto()))
                .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(orderDto.getPreOrderDto()));
    }

    public static OrderDto orderToOrderDto(Order order){
        return new OrderDto()
                .setCreatedDate(order.getCreatedDate())
                .setId(order.getId())
                .setStatus(order.getStatus())
                .setCreatedDate(order.getCreatedDate())
                .setTransactionDto(TransactionMapper.transactionToTransactionDto(order.getTransaction()))
                .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(order.getPreOrder()));
    }

    public static List<Order> ordersDtoToOrders(List<OrderDto> orderDtos){
        List<Order> orders = new ArrayList<>();

        for (OrderDto orderDto: orderDtos){
            Order order = new Order()
                    .setStatus(orderDto.getStatus())
                    .setTransaction(TransactionMapper.transactionDtoToTransaction(orderDto.getTransactionDto()))
                    .setPreOrder(PreOrderMapper.preOrderDtoToPreOrder(orderDto.getPreOrderDto()));
            orders.add(order);
        }


        return orders;
    }

    public static List<OrderDto> ordersToOrdersDto(List<Order> orders){

        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order: orders){
            OrderDto orderDto = new OrderDto()
                    .setCreatedDate(order.getCreatedDate())
                    .setId(order.getId())
                    .setStatus(order.getStatus())
                    .setCreatedDate(order.getCreatedDate())
                    .setTransactionDto(TransactionMapper.transactionToTransactionDto(order.getTransaction()))
                    .setPreOrderDto(PreOrderMapper.preOrderToPreOrder(order.getPreOrder()));
            orderDtos.add(orderDto);
        }


        return  orderDtos;

    }
}

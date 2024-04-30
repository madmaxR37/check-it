package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.dto.mappers.OrderMapper;
import com.example.checkit.model.Order;
import com.example.checkit.model.Transaction;
import com.example.checkit.repository.OrderRepository;
import com.example.checkit.repository.TransactionRepository;
import com.example.checkit.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public OrderDto createOrder(TransactionDto transactionDto) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionDto.getId());
        if (transaction.isPresent()){
            Transaction transactionModel= transaction.get();
            if (transactionModel.getStatus()){
                Order order = new Order()
                        .setPreOrder(transactionModel.getPreOrder());
                orderRepository.save(order);
                return OrderMapper.orderToOrderDto(order);
            }
        }


        return null;
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

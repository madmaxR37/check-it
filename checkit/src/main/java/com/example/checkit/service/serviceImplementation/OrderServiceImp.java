package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.dto.mappers.OrderMapper;
import com.example.checkit.model.Order;
import com.example.checkit.model.Transaction;
import com.example.checkit.model.User;
import com.example.checkit.repository.OrderRepository;
import com.example.checkit.repository.TransactionRepository;
import com.example.checkit.repository.UserRepository;
import com.example.checkit.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final TransactionRepository transactionRepository;

    public OrderServiceImp(OrderRepository orderRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public OrderDto createOrder(TransactionDto transactionDto) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionDto.getId());
        if (transaction.isPresent()){
            Transaction transactionModel= transaction.get();
            if (transactionModel.getStatus()){
                Optional<User> user= userRepository.findById(transactionDto.getPreOrderDto().getCartDto().getPurchaseLineDto().get(0).getItemDto().getSellerId());
                if (user.isPresent()){
                    User sellerModel = user.get();
                    sellerModel.setAccountBalance(sellerModel.getAccountBalance()+transactionDto.getAmount());
                    userRepository.save(sellerModel);
                    Order order = new Order().setPreOrder(transactionModel.getPreOrder());
                    orderRepository.save(order);
                    return OrderMapper.orderToOrderDto(order);
                }
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

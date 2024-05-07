package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.OrderDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.dto.mappers.OrderMapper;
import com.example.checkit.model.Order;
import com.example.checkit.model.Seller;
import com.example.checkit.model.Transaction;
import com.example.checkit.repository.OrderRepository;
import com.example.checkit.repository.SellerRepository;
import com.example.checkit.repository.TransactionRepository;
import com.example.checkit.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    private final SellerRepository sellerRepository;

    private final TransactionRepository transactionRepository;

    public OrderServiceImp(OrderRepository orderRepository, SellerRepository sellerRepository, TransactionRepository transactionRepository) {
        this.orderRepository = orderRepository;
        this.sellerRepository = sellerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public OrderDto createOrder(TransactionDto transactionDto) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionDto.getId());
        if (transaction.isPresent()){
            Transaction transactionModel= transaction.get();
            if (transactionModel.getStatus()){
                Optional<Seller> seller=sellerRepository.findById(transactionDto.getPreOrderDto().getCartDto().getPurchaseLineDto().get(0).getItemDto().getSellerId());
                if (seller.isPresent()){
                    Seller sellerModel = seller.get();
                    sellerModel.setAccountBalance(sellerModel.getAccountBalance()+transactionDto.getAmount());
                    sellerRepository.save(sellerModel);
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

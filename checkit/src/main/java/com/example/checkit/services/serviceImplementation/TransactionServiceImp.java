package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.CreditCardDto;
import com.example.checkit.dtos.MobileDto;
import com.example.checkit.dtos.TransactionDto;
import com.example.checkit.dtos.mappers.TransactionMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.exceptions.TransactionFailedException;
import com.example.checkit.models.*;
import com.example.checkit.repositories.*;
import com.example.checkit.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    private final DeliveryRepository deliveryRepository;

    private final PreOrderRepository preOrderRepository;

    private final OrderRepository orderRepository;


    public TransactionServiceImp(TransactionRepository transactionRepository,
                                 UserRepository userRepository,
                                 DeliveryRepository deliveryRepository,
                                 PreOrderRepository preOrderRepository, OrderRepository orderRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
        this.preOrderRepository = preOrderRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Object preOrderTransaction(Object transactionDto, Long preOrderId) {

        Optional<PreOrder> preOrder = preOrderRepository.findById(preOrderId);
        if (preOrder.isPresent()){

            Optional<User> clientOptional = userRepository.findById(preOrder.get().getCart().getClient().getId());
            Optional<User> sellerOptional = userRepository.findById(preOrder.get().getCart().getPurchaseLine().get(0).getItem().getSeller().getId());
            if (sellerOptional.isPresent()){
           if (clientOptional.isPresent()){
               User seller = sellerOptional.get();
               User client = clientOptional.get();
            if (transactionDto instanceof TransactionDto){
                Transaction transaction = new Transaction()
                        .setPreOrder(preOrder.get())
                        .setAmount(preOrder.get().getTotalCost());
                 if (accountBalanceCheck(client.getAccountBalance(),preOrder.get().getTotalCost())){
                    client.setAccountBalance(debitAccount(client.getAccountBalance(),preOrder.get().getTotalCost()));
                    seller.setAccountBalance(creditAccount(seller.getAccountBalance(),preOrder.get().getTotalCost()));
                    transaction.setStatus(true);
                  userRepository.save(seller);
                  userRepository.save(client);
                     OrderEntity orderEntity = new OrderEntity()
                             .setStatus(false)
                             .setPreOrder(preOrder.get());
                     orderRepository.save(orderEntity);
                     transaction.setOrderEntity(orderEntity);
                 return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                 }
               // throw new  TransactionFailedException("insufficient account balance", HttpStatus.BAD_REQUEST);

            }

            if (transactionDto instanceof MobileDto){
                Mobile transaction = (Mobile) new Mobile()
                        .setPreOrder(preOrder.get())
                        .setAmount(preOrder.get().getTotalCost());
                if (validateMobileTransaction(((MobileDto) transactionDto).getNumber(),
                        preOrder.get().getTotalCost())){
                    seller.setAccountBalance(creditAccount(seller.getAccountBalance(),
                            preOrder.get().getTotalCost()));
                    transaction.setStatus(true);
                    userRepository.save(seller);
                    OrderEntity orderEntity = new OrderEntity()
                            .setPreOrder(preOrder.get());
                    orderRepository.save(orderEntity);
                    return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                }


            }
            if (transactionDto instanceof CreditCardDto){
                CreditCard transaction = (CreditCard) new CreditCard()
                        .setPreOrder(preOrder.get())
                        .setAmount(preOrder.get().getTotalCost());
                if (validateCardTransaction(((CreditCardDto) transactionDto).getCreditCartNumber(),
                        ((CreditCardDto) transactionDto).getCvv(),
                        ((CreditCardDto) transactionDto).getExpDate(),
                        preOrder.get().getTotalCost())){
                    seller.setAccountBalance(creditAccount(seller.getAccountBalance(),
                            (transaction).getAmount()));
                    transaction.setStatus(true);
                    userRepository.save(seller);
                    OrderEntity orderEntity = new OrderEntity()
                            .setPreOrder(preOrder.get());
                    orderRepository.save(orderEntity);
                    return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                }

            }
           }
                throw new EntityNotFoundException("this client doesn't exist", HttpStatus.NOT_FOUND);

            }
            throw new EntityNotFoundException("this seller doesn't exist", HttpStatus.NOT_FOUND);


        }

        throw new EntityNotFoundException("this preorder doesn't exist", HttpStatus.NOT_FOUND);
    }

    public Boolean accountBalanceCheck(float accountBalance, float checkAmount){

        return checkAmount <= accountBalance;

    }
    public float debitAccount(float accountBalance, float debitAmount){
        return accountBalance - debitAmount;
    }

    public float creditAccount(float accountBalance, float creditAmount){
        return accountBalance + creditAmount;
    }
    public Boolean validateMobileTransaction(String mobileNumber, float amount){
        return true;
    }

    public Boolean validateCardTransaction(String cardNumber,String cvv, String expDate, float amount){
        return true;
    }
}
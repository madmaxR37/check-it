package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CreditCardDto;
import com.example.checkit.dto.MobileDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.dto.mappers.TransactionMapper;
import com.example.checkit.model.*;
import com.example.checkit.repository.*;
import com.example.checkit.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    private final DeliveryRepository deliveryRepository;

    private final PreOrderRepository preOrderRepository;


    public TransactionServiceImp(TransactionRepository transactionRepository,
                                 UserRepository userRepository,
                                 DeliveryRepository deliveryRepository,
                                 PreOrderRepository preOrderRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
        this.preOrderRepository = preOrderRepository;
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
                 return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                 }
            }
            if (transactionDto instanceof MobileDto){
                Mobile transaction = (Mobile) new Mobile()
                        .setPreOrder(preOrder.get())
                        .setAmount(preOrder.get().getTotalCost());
                if (validateMobileTransaction(((MobileDto) transactionDto).getNumber(),
                        preOrder.get().getTotalCost())){
                    seller.setAccountBalance(creditAccount(seller.getAccountBalance(),
                            ((MobileDto) transactionDto).getAmount()));
                    transaction.setStatus(true);
                    userRepository.save(seller);
                    return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                }

            }
            if (transactionDto instanceof CreditCardDto){
                CreditCard transaction = (CreditCard) new CreditCard()
                        .setPreOrder(preOrder.get())
                        .setAmount(preOrder.get().getTotalCost());
                if (validateCardTransaction(((CreditCardDto) transactionDto).getCreditCartNumber(),
                        ((CreditCardDto) transactionDto).getCvv(),
                        ((CreditCardDto) transactionDto).getDate(),
                        preOrder.get().getTotalCost())){
                    seller.setAccountBalance(creditAccount(seller.getAccountBalance(),
                            ((CreditCardDto) transactionDto).getAmount()));
                    transaction.setStatus(true);
                    userRepository.save(seller);
                    return TransactionMapper.transactionToTransactionDto(transactionRepository.save(transaction));
                }

            }
           }

            }


        }

        return null;
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

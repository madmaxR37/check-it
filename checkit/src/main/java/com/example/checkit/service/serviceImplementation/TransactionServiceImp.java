package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.*;
import com.example.checkit.dto.mappers.CreditCardMapper;
import com.example.checkit.dto.mappers.MobileMapper;
import com.example.checkit.dto.mappers.TransactionMapper;
import com.example.checkit.model.*;
import com.example.checkit.repository.*;
import com.example.checkit.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final SellerRepository sellerRepository;

    private final CreditCardRepository cardRepository;

    private final DeliveryRepository deliveryRepository;

    private final MobileRepository mobileRepository;

    private final PreOrderRepository preOrderRepository;

    private final ItemRepository itemRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository,
                                 SellerRepository sellerRepository,
                                 CreditCardRepository cardRepository,
                                 DeliveryRepository deliveryRepository,
                                 MobileRepository mobileRepository,
                                 PreOrderRepository preOrderRepository,
                                 ItemRepository itemRepository) {
        this.transactionRepository = transactionRepository;
        this.sellerRepository = sellerRepository;
        this.cardRepository = cardRepository;
        this.deliveryRepository = deliveryRepository;
        this.mobileRepository = mobileRepository;
        this.preOrderRepository = preOrderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public TransactionDto createOrderMobileTransaction(MobileDto mobileDto) {
        Optional<PreOrder> preOrder = preOrderRepository.findById(mobileDto.getPreOrderDto().getId());
        if(preOrder.isPresent()){
            PreOrder preOrderModel = preOrder.get();
            mobileDto.setAmount(preOrderModel.getTotalCost())
                     .setStatus(setTransactionStatus(preOrderModel.getTotalCost()));
            mobileRepository.save(MobileMapper.mobileDtoToMobile(mobileDto));
            return mobileDto;
        }
        return null;
    }

    @Override
    public TransactionDto createOrderCreditCardTransaction(CreditCardDto creditCardDto) {
        Optional<PreOrder> preOrder = preOrderRepository.findById(creditCardDto.getPreOrderDto().getId());
        if(preOrder.isPresent()){
            PreOrder preOrderModel = preOrder.get();
            creditCardDto
                    .setAmount(preOrderModel.getTotalCost())
                    .setStatus(setTransactionStatus(preOrderModel.getTotalCost()));

            }

            cardRepository.save(CreditCardMapper.creditCartDtoToCreditCart(creditCardDto));
            return creditCardDto;
        }


    @Override
    public TransactionDto createDeliveryTransaction(DeliveryDto deliveryDto) {
        Optional<Delivery> delivery = deliveryRepository.findById(deliveryDto.getId());
        Optional<Seller> seller = sellerRepository.findById(deliveryDto.getSellerDto().getId());
        if (delivery.isPresent() && seller.isPresent()){
            Seller sellerModel=seller.get();
            Delivery deliveryModel = delivery.get();
            if (deliveryModel.getDeliveryCost()<= sellerModel.getAccountBalance()){
                sellerModel.setAccountBalance(sellerModel.getAccountBalance()-deliveryModel.getDeliveryCost());
                sellerRepository.save(sellerModel);
                deliveryModel.setPaymentStatus(true);
                deliveryRepository.save(deliveryModel);
                Transaction transaction = new Transaction();
                transaction.setDelivery(deliveryModel)
                        .setAmount(deliveryModel.getDeliveryCost())
                        .setStatus(true);
                transactionRepository.save(transaction);
                return TransactionMapper.transactionToTransactionDto(transaction);

            }
        }
        return null;
    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public List<TransactionDto> findAllTransactionsBYUserId(Long id) {
        return null;
    }

    public Boolean setTransactionStatus(float cost){
        return true;
    }
}

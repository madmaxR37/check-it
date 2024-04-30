package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CreditCartDto;
import com.example.checkit.dto.MobileDto;
import com.example.checkit.dto.TransactionDto;
import com.example.checkit.dto.mappers.MobileMapper;
import com.example.checkit.dto.mappers.TransactionMapper;
import com.example.checkit.model.PreOrder;
import com.example.checkit.repository.MobileRepository;
import com.example.checkit.repository.PreOrderRepository;
import com.example.checkit.repository.TransactionRepository;
import com.example.checkit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImp implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private PreOrderRepository preOrderRepository;

    @Override
    public TransactionDto createTransactionMobile(MobileDto mobileDto) {
        Optional<PreOrder> preOrder = preOrderRepository.findById(mobileDto.getPreOrderDto().getId());
        if(preOrder.isPresent()){
            PreOrder preOrderModel = preOrder.get();
            mobileDto
                    .setAmount(preOrderModel.getTotalCost())//TODO implement promises
                    .setStatus(setTransactionStatus(preOrderModel.getTotalCost()));
            mobileRepository.save(MobileMapper.mobileDtoToMobile(mobileDto));
            return mobileDto;
        }
        return null;
    }

    @Override
    public TransactionDto createTransactionCreditCart(CreditCartDto creditCartDto) {

        Optional<PreOrder> preOrder = preOrderRepository.findById(creditCartDto.getPreOrderDto().getId());
        if(preOrder.isPresent()){
            PreOrder preOrderModel = preOrder.get();
            creditCartDto
                    .setAmount(preOrderModel.getTotalCost())
                    .setStatus(setTransactionStatus(preOrderModel.getTotalCost()));//TODO implement promises
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

package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.dto.AddressDto;
import com.example.checkit.dto.mappers.PreOrderMapper;
import com.example.checkit.repository.PreOrderRepository;
import com.example.checkit.service.PreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreOrderServiceImp  implements PreOrderService {

    @Autowired
    private PreOrderRepository preOrderRepository;
    @Override
    public PreOrderDto createPreOrder(PreOrderDto preOrderDto) {
        preOrderDto
                .setTripDistance(calculateTripeDistance(preOrderDto
                        .getClientAddressDto(),
                        preOrderDto
                                .getCardDto()
                                .getPurchaseLineDto()
                                .get(0)
                                .getItemDto()
                                .getSellerDto()
                                .getAddressDto()))
                .setDeliveryCost(calculateDeliveryCost(preOrderDto.getTripDistance()))
                .setTotalCost(calculateTotalExpense());//TODO implement Async feature
        preOrderRepository.save(PreOrderMapper.preOrderDtoToPreOrder(preOrderDto));
        return null;
    }

    @Override
    public PreOrderDto findOrderById(Long id) {
        return null;
    }

    @Override
    public PreOrderDto updateOrder(PreOrderDto orderDto) {
        return null;
    }

    @Override
    public List<PreOrderDto> findAllOrders() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public Float calculateTripeDistance(AddressDto clientAddressDto, AddressDto sellerAddressDto){
        //TODO Google API
        return null;
    }

    public Float calculateDeliveryCost(float tripeDistance){
        //TODO
        return null;
    }

    public Float calculateTotalExpense(){
        //TODO
        return null;
    }
}

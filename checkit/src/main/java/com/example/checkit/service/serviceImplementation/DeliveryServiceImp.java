package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.AddressDto;
import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.dto.mappers.DeliveryMapper;
import com.example.checkit.model.Seller;
import com.example.checkit.repository.DeliveryRepository;
import com.example.checkit.repository.SellerRepository;
import com.example.checkit.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImp implements DeliveryService {


    private final DeliveryRepository deliveryRepository;

    private final SellerRepository sellerRepository;

    public DeliveryServiceImp(DeliveryRepository deliveryRepository, SellerRepository sellerRepository) {
        this.deliveryRepository = deliveryRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public DeliveryDto createDelivery(DeliveryDto dto) {

        Optional<Seller> seller = sellerRepository.findById(dto.getSellerDto().getId());
        if (seller.isPresent()){
            dto.setDeliveryCost(calculateDeliveryCost
                    (calculateTripeDistance
                            (dto.getOrderDto()
                            .getPreOrderDto()
                            .getClientAddressDto(),
                    dto.getSellerLocation())));
            deliveryRepository.save(DeliveryMapper.deliveryDtoToDelivery(dto));
        }
        return null;
    }

    @Override
    public DeliveryDto update(DeliveryDto dto) {
        return null;
    }

    @Override
    public List<DeliveryDto> findAllByDeliveryManId(Long id) {
        return null;
    }

    @Override
    public List<DeliveryDto> findAllByClientId(Long id) {
        return null;
    }

    @Override
    public List<DeliveryDto> findAllBySellerId(Long id) {
        return null;
    }

    @Override
    public void deleteDelivery(Long id) {

    }
    public Float calculateTripeDistance(AddressDto clientAddressDto, AddressDto sellerAddressDto){
        //TODO Google API
        return null;
    }

    public Float calculateDeliveryCost(float tripeDistance){
        //TODO
        return null;
    }

}

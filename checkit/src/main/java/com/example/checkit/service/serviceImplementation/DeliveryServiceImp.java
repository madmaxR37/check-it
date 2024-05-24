package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.AddressDto;
import com.example.checkit.dto.DeliveryDto;
import com.example.checkit.dto.mappers.DeliveryMapper;
import com.example.checkit.model.User;
import com.example.checkit.repository.DeliveryRepository;
import com.example.checkit.repository.UserRepository;
import com.example.checkit.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImp implements DeliveryService {


    private final DeliveryRepository deliveryRepository;

    private final UserRepository userRepository;

    public DeliveryServiceImp(DeliveryRepository deliveryRepository,
                              UserRepository userRepository) {
        this.deliveryRepository = deliveryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DeliveryDto createDelivery(DeliveryDto dto) {

        Optional<User> user = userRepository.findById(dto.getSellerDto().getId());
        if (user.isPresent()){
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

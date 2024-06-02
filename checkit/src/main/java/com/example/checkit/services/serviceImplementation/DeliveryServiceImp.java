package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.AddressDto;
import com.example.checkit.dtos.DeliveryDto;
import com.example.checkit.dtos.mappers.AddressMapper;
import com.example.checkit.dtos.mappers.DeliveryMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Delivery;
import com.example.checkit.models.OrderEntity;
import com.example.checkit.models.Seller;
import com.example.checkit.models.User;
import com.example.checkit.repositories.DeliveryRepository;
import com.example.checkit.repositories.OrderRepository;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImp implements DeliveryService {


    private final DeliveryRepository deliveryRepository;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public DeliveryServiceImp(DeliveryRepository deliveryRepository,
                              UserRepository userRepository, OrderRepository orderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public DeliveryDto createDelivery(DeliveryDto dto, Long orderId, Long sellerId) {

        Optional<OrderEntity> order = orderRepository.findById(orderId);
        Optional<User> seller =  userRepository.findById(sellerId);
        if (order.isPresent() && seller.isPresent()){
            Seller sellerModel = (Seller) seller.get();
           Delivery delivery = DeliveryMapper.deliveryDtoToDelivery(dto);
           delivery.setPaymentStatus(false)
                           .setDeliveryCost(calculateDeliveryCost(calculateTripeDistance
                                   (AddressMapper.addressToAddressDto
                                                   (order.get().getPreOrder().getClientAddress()),
                                   dto.getSellerLocation())))
                   .setAcceptanceStatus(false)
                   .setSeller(sellerModel)
                   .setOrderEntity(order.get());
            deliveryRepository.save(delivery);
            return DeliveryMapper.deliveryToDeliveryDto(delivery);
        }
        throw new EntityNotFoundException("this seller or order doesn't exist", HttpStatus.NOT_FOUND);
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
    public float calculateTripeDistance(AddressDto clientAddressDto, AddressDto sellerAddressDto){
        //TODO Google API
        return 120;
    }

    public float calculateDeliveryCost(float tripeDistance){
        //TODO
        return 1000;
    }

}

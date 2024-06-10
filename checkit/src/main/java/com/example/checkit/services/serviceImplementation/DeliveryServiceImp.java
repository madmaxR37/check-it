package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.AddressDto;
import com.example.checkit.dtos.DeliveryDto;
import com.example.checkit.dtos.mappers.AddressMapper;
import com.example.checkit.dtos.mappers.DeliveryMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.*;
import com.example.checkit.repositories.DeliveryRepository;
import com.example.checkit.repositories.OrderRepository;
import com.example.checkit.repositories.UserRepository;
import com.example.checkit.services.DeliveryService;
import com.example.checkit.services.externalServices.GraphHopperService;
import com.example.checkit.utils.DeliveryConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImp implements DeliveryService {


    private final DeliveryRepository deliveryRepository;

    private final GraphHopperService graphHopperService;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public DeliveryServiceImp(DeliveryRepository deliveryRepository,
                              GraphHopperService graphHopperService, UserRepository userRepository, OrderRepository orderRepository) {
        this.deliveryRepository = deliveryRepository;
        this.graphHopperService = graphHopperService;
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
                                   (order.get().getPreOrder().getClientAddress(),
                                   AddressMapper.addressDtoToAddress(dto.getSellerLocation()))))
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
    public float calculateTripeDistance(Address clientAddress, Address sellerAddress){
        return graphHopperService.distance(clientAddress,sellerAddress);
    }

    public float calculateDeliveryCost(float tripeDistance){
        double fuelCost = tripeDistance/1000 * DeliveryConstants.FUEL_CONSUMPTION_RATE * DeliveryConstants.FUEL_PRICE;
        double deliveryPrice = fuelCost + DeliveryConstants.BASE_DELIVERY_CHARGE;
        return (float) deliveryPrice;
    }

}

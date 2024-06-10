package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.PreOrderDto;
import com.example.checkit.dtos.AddressDto;
import com.example.checkit.dtos.mappers.AddressMapper;
import com.example.checkit.dtos.mappers.PreOrderMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Address;
import com.example.checkit.models.Cart;
import com.example.checkit.models.PreOrder;
import com.example.checkit.repositories.CartRepository;
import com.example.checkit.repositories.PreOrderRepository;
import com.example.checkit.services.PreOrderService;
import com.example.checkit.services.externalServices.GraphHopperService;
import com.example.checkit.utils.DeliveryConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PreOrderServiceImp  implements PreOrderService {

    private final PreOrderRepository preOrderRepository;

    private final GraphHopperService graphHopperService;
    private final CartRepository cartRepository;

    public PreOrderServiceImp(PreOrderRepository preOrderRepository, GraphHopperService graphHopperService, CartRepository cartRepository) {
        this.preOrderRepository = preOrderRepository;
        this.graphHopperService = graphHopperService;
        this.cartRepository = cartRepository;
    }

    @Override
    public PreOrderDto createPreOrder(PreOrderDto preOrderDto,Long cartId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            PreOrder preOrder = PreOrderMapper.preOrderDtoToPreOrder(preOrderDto);
                preOrder.setCart(cart)
                        .setTripDistance(calculateTripeDistance(preOrderDto.getClientAddressDto(),
                                cart.getPurchaseLine().get(0).getItem().getSeller().getAddress()))
                        .setDeliveryCost(calculateDeliveryCost(preOrder.getTripDistance()))
                        .setTotalCost(calculateTotalExpense(preOrder.getDeliveryCost(),cart.getTotalItemsCost()));
            return PreOrderMapper.preOrderToPreOrder(preOrderRepository.save(preOrder));
        }
        throw new EntityNotFoundException("this cart doesn't exist", HttpStatus.NOT_FOUND);
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

    public Float calculateTripeDistance(AddressDto clientAddressDto, Address sellerAddress){
        return graphHopperService.distance(AddressMapper.addressDtoToAddress(clientAddressDto),sellerAddress);
    }

    public float calculateDeliveryCost(float tripeDistance){
        double fuelCost = tripeDistance/1000 * DeliveryConstants.FUEL_CONSUMPTION_RATE * DeliveryConstants.FUEL_PRICE;
        double deliveryPrice = fuelCost + DeliveryConstants.BASE_DELIVERY_CHARGE;
        return (float) deliveryPrice;

    }
    public float calculateTotalExpense(float delivery, float item_cost){
        return delivery+item_cost;
    }
}

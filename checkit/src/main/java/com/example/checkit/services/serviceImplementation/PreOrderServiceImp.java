package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.PreOrderDto;
import com.example.checkit.dtos.AddressDto;
import com.example.checkit.dtos.mappers.AddressMapper;
import com.example.checkit.dtos.mappers.PreOrderMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Cart;
import com.example.checkit.models.PreOrder;
import com.example.checkit.repositories.CartRepository;
import com.example.checkit.repositories.PreOrderRepository;
import com.example.checkit.services.PreOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreOrderServiceImp  implements PreOrderService {

    private final PreOrderRepository preOrderRepository;

    private final CartRepository cartRepository;

    public PreOrderServiceImp(PreOrderRepository preOrderRepository, CartRepository cartRepository) {
        this.preOrderRepository = preOrderRepository;
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
                                    AddressMapper.addressToAddressDto(cart.getPurchaseLine().get(0).getItem().getSeller().getAddress())))
                            .setDeliveryCost(calculateDeliveryCost(preOrder.getTripDistance()))
                            .setTotalCost(calculateTotalExpense(preOrder.getDeliveryCost(),cart.getTotalItemsCost())); //TODO implement Async feature

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

    public float calculateTripeDistance(AddressDto clientAddressDto, AddressDto sellerAddressDto){
        //TODO Google API
        return  2000;
    }

    public float calculateDeliveryCost(float tripeDistance){
        //TODO
        return 1000;
    }

    public float calculateTotalExpense(float delivery, float item_cost){
        //TODO
        return delivery+item_cost;
    }
}

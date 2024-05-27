package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.PreOrderDto;
import com.example.checkit.dto.AddressDto;
import com.example.checkit.dto.mappers.CartMapper;
import com.example.checkit.dto.mappers.PreOrderMapper;
import com.example.checkit.model.Cart;
import com.example.checkit.model.PreOrder;
import com.example.checkit.repository.CartRepository;
import com.example.checkit.repository.PreOrderRepository;
import com.example.checkit.service.PreOrderService;
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
            CartDto cartDto = CartMapper.cardToCardDto(cartOptional.get());
            preOrderDto.setCartDto(cartDto);
            preOrderDto
                    .setTripDistance(calculateTripeDistance(preOrderDto.getClientAddressDto(),
                            preOrderDto
                                    .getCartDto()
                                    .getPurchaseLineDto()
                                    .get(0)
                                    .getItemDto()
                                    .getSellerDto()
                                    .getAddressDto()))
                    .setDeliveryCost(calculateDeliveryCost(preOrderDto.getTripDistance()))
                    .setTotalCost(calculateTotalExpense()); //TODO implement Async feature

            PreOrder preOrder = preOrderRepository.save(PreOrderMapper.preOrderDtoToPreOrder(preOrderDto));
            return PreOrderMapper.preOrderToPreOrder(preOrder);
        }
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

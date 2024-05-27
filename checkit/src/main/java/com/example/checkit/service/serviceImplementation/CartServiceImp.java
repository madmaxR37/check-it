package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.dto.mappers.CartMapper;
import com.example.checkit.dto.mappers.PurchaseLineMapper;
import com.example.checkit.model.*;
import com.example.checkit.repository.*;
import com.example.checkit.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    private final ItemRepository itemRepository;

    private final PurchaseLineRepository purchaseLineRepository;

    private final CartRepository cartRepository;


    private final UserRepository userRepository;

    public CartServiceImp(ItemRepository itemRepository,
                          PurchaseLineRepository purchaseLineRepository,
                          CartRepository cartRepository,
                          UserRepository userRepository){
        this.itemRepository=itemRepository;
        this.purchaseLineRepository=purchaseLineRepository;
        this.cartRepository=cartRepository;
        this.userRepository=userRepository;
    }

    @Override
    public CartDto createCard(Long clientId, Long purchaseLineId) {

        Optional<User> user = userRepository.findById(clientId);
        Optional<PurchaseLine> purchaseLine = purchaseLineRepository.findById(purchaseLineId);
        if (purchaseLine.isPresent()) {
            PurchaseLine purchaseLineModel = purchaseLine.get();
            PurchaseLineDto purchaseLineDto = PurchaseLineMapper.purchaseLineToPurchaseLineDto(purchaseLineModel);
            Optional<Item> item = itemRepository.findById(purchaseLineDto.getItemDto().getId());
        if (user.isPresent()){
            if(item.isPresent()){
                    Item itemModel = item.get();
                    if (itemModel.getQuantity() >= purchaseLineDto.getQuantity()) {
                        Optional<Cart> cartOptional = cartRepository.findByName(purchaseLineDto.getItemDto().getSellerDto().getFirstname() + '#' + purchaseLineDto.getItemDto().getSellerDto().getId() + '#' + clientId);
                        Cart cart;
                        if (cartOptional.isPresent()) {
                            cart = cartOptional.get();
                            List<PurchaseLineDto> purchaseLineDtos = PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine());
                            purchaseLineDtos.add(purchaseLineDto);
                            float sum = 0;
                            int totalItems = 0;
                            for (PurchaseLineDto dto : purchaseLineDtos) {
                                sum += dto.getPrice();
                                totalItems += dto.getQuantity();
                            }
                            cart
                                    .setTotalItemsCost(sum)
                                    .setTotalItemsQuantity(totalItems);
                            cart.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos));


                        } else {
                            cart = new Cart();
                            List<PurchaseLineDto> purchaseLineDtos = new ArrayList<>();
                            purchaseLineDtos.add(purchaseLineDto);
                            float sum = 0;
                            int totalItems = 0;
                            for (PurchaseLineDto dto : purchaseLineDtos) {
                                sum += dto.getPrice();
                                totalItems += dto.getQuantity();
                            }
                            cart.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos))
                                    .setName(purchaseLineDto.getItemDto().getSellerDto().getFirstname() + '#' + purchaseLineDto.getItemDto().getSellerDto().getId() + '#' + clientId)
                                    .setIsActiveStatus(true)
                                    .setTotalItemsCost(sum)
                                    .setTotalItemsQuantity(totalItems);

                        }
                        cartRepository.save(cart);
                        return CartMapper.cardToCardDto(cart);
                    }
                }
            }

        }

        return null;
    }

    @Override
    public CartDto updateCard(CartDto cartDto) {
        return null;
    }
}

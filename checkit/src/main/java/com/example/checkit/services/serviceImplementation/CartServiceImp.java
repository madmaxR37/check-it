package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.CartDto;
import com.example.checkit.dtos.mappers.CartMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.*;
import com.example.checkit.repositories.*;
import com.example.checkit.services.CartService;
import org.springframework.http.HttpStatus;
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
            Optional<Item> item = itemRepository.findById(purchaseLineModel.getItem().getId());
        if (user.isPresent()){
            if(item.isPresent() && item.get().getAvailableStatus()){

                        Optional<Cart> cartOptional = cartRepository.findByName(purchaseLineModel.getItem().getSeller().getFirstname() + '#' + purchaseLineModel.getItem().getSeller().getId() + '#' + clientId);
                        Cart cart;
                        if (cartOptional.isPresent()) {
                            cart = cartOptional.get();
                            List<PurchaseLine> purchaseLineModels = cart.getPurchaseLine();
                            purchaseLineModels.add(purchaseLineModel);
                            float sum = 0;
                            int totalItems = 0;
                            for (PurchaseLine purchaseline : purchaseLineModels) {
                                sum += purchaseline.getPrice();
                                totalItems += purchaseline.getQuantity();
                            }
                            cart
                                    .setTotalItemsCost(sum)
                                    .setTotalItemsQuantity(totalItems)
                                    .setClient((Client) user.get());
                            cart.setPurchaseLine(purchaseLineModels);
                            purchaseLineModel.setCart(cart);
                            cartRepository.save(cart);
                            purchaseLineRepository.save(purchaseLineModel);
                            return CartMapper.cartToCartDto(cart);


                        } else {
                            cart = new Cart();
                            List<PurchaseLine> purchaseLineModels = new ArrayList<>();
                            purchaseLineModels.add(purchaseLineModel);
                            float sum = 0;
                            int totalItems = 0;
                            for (PurchaseLine model : purchaseLineModels) {
                                sum += model.getPrice();
                                totalItems += model.getQuantity();
                            }
                            cart.setPurchaseLine(purchaseLineModels)
                                    .setName(purchaseLineModel.getItem().getSeller().getFirstname() + '#' + purchaseLineModel.getItem().getSeller().getId() + '#' + clientId)
                                    .setIsActiveStatus(true)
                                    .setTotalItemsCost(sum)
                                    .setTotalItemsQuantity(totalItems)
                                    .setClient((Client) user.get());

                        }
                        cartRepository.save(cart);
                        purchaseLineModel.setCart(cart);
                        purchaseLineRepository.save(purchaseLineModel);
                        return CartMapper.cartToCartDto(cart);


                }
            throw new EntityNotFoundException("this item doesn't exist or is not available", HttpStatus.NOT_FOUND);
            }
            throw new EntityNotFoundException("this user doesn't exist", HttpStatus.NOT_FOUND);
        }

          throw new EntityNotFoundException("this purchase line doesn't exist", HttpStatus.NOT_FOUND);

    }

    @Override
    public CartDto updateCard(CartDto cartDto) {
        return null;
    }
}

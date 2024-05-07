package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CartDto;
import com.example.checkit.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {

    public static List<CartDto> cardsToCardDtos(List<Cart> carts){

        List<CartDto> listDtos = new ArrayList<>();

        for(Cart cart : carts){
            CartDto cartDto = new CartDto();
            cartDto
                    .setId(cart.getId())
                    .setName(cart.getName())
                    .setIsActiveStatus(cart.getIsActiveStatus())
                    .setTotalItemsCost(cart.getTotalItemsCost())
                    .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine()));
            listDtos.add(cartDto);
        }

        return listDtos ;

    }

    public static List<Cart> cardDtosToCards(List<CartDto> cartDtos){

        List<Cart> carts = new ArrayList<>();
                for (CartDto cartDto : cartDtos){
                    Cart cart = new Cart();
                    cart
                            .setId(cartDto.getId())
                            .setName(cart.getName())
                            .setIsActiveStatus(cartDto.getIsActiveStatus())
                            .setTotalItemsCost(cartDto.getTotalItemsCost())
                            .setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(cartDto.getPurchaseLineDto()));
                    carts.add(cart);
                }


        return carts;

    }
    public static Cart cardDtoToCard(CartDto cartDto){
        return new Cart()
                .setId(cartDto.getId())
                .setClient(ClientMapper.clientDtoToClient(cartDto.getClientDto()))
                .setIsActiveStatus(cartDto.getIsActiveStatus())
                .setTotalItemsCost(cartDto.getTotalItemsCost())
                .setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(cartDto.getPurchaseLineDto()));
    }

    public static CartDto cardToCardDto(Cart cart){
        return new CartDto()
                .setId(cart.getId())
                .setClientId(ClientMapper.clientToClientDto(cart.getClient()).getId())
                .setIsActiveStatus(cart.getIsActiveStatus())
                .setTotalItemsCost(cart.getTotalItemsCost())
                .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine()));
    }
}

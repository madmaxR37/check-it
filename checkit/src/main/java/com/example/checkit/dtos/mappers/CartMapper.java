package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.CartDto;
import com.example.checkit.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartMapper {

    public static List<CartDto> cartsToCartDtos(List<Cart> carts){

        List<CartDto> listDtos = new ArrayList<>();

        for(Cart cart : carts){
            CartDto cartDto = new CartDto();
            cartDto
                    .setId(cart.getId())
                    .setName(cart.getName())
                    .setIsActiveStatus(cart.getIsActiveStatus())
                    .setName(cart.getName())
                    .setTotalItemsQuantity(cart.getTotalItemsQuantity())
                    .setTotalItemsCost(cart.getTotalItemsCost())
                    .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine()));


            listDtos.add(cartDto);
        }

        return listDtos ;

    }

    public static List<Cart> cartDtosToCarts(List<CartDto> cartDtos){

        List<Cart> carts = new ArrayList<>();
                for (CartDto cartDto : cartDtos){
                    Cart cart = new Cart();
                    cart
                            .setName(cart.getName())
                            .setIsActiveStatus(cartDto.getIsActiveStatus())
                            .setTotalItemsCost(cartDto.getTotalItemsCost());
                    carts.add(cart);
                }


        return carts;

    }
    public static Cart cartDtoToCart(CartDto cartDto){
        return new Cart()
                .setId(cartDto.getId())
                .setIsActiveStatus(cartDto.getIsActiveStatus())
                .setTotalItemsCost(cartDto.getTotalItemsCost());
    }

    public static CartDto cartToCartDto(Cart cart){
        return new CartDto()
                 .setId(cart.getId())
                 .setName(cart.getName())
                 .setTotalItemsQuantity(cart.getTotalItemsQuantity())
                 .setIsActiveStatus(cart.getIsActiveStatus())
                 .setTotalItemsCost(cart.getTotalItemsCost())
                 .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine()));

    }
}

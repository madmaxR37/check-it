package com.example.checkit.services;

import com.example.checkit.dtos.CartDto;


public interface CartService {

    CartDto createCard(Long clientId,Long PurchaseLineId);

    CartDto updateCard(CartDto cartDto);
}

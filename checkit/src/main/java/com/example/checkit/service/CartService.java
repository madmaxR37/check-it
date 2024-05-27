package com.example.checkit.service;

import com.example.checkit.dto.CartDto;


public interface CartService {

    CartDto createCard(Long clientId,Long PurchaseLineId);

    CartDto updateCard(CartDto cartDto);
}

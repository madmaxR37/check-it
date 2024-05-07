package com.example.checkit.service;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.PurchaseLineDto;

public interface CartService {

    CartDto createCard(PurchaseLineDto purchaseLineDto, Long clientId);

    CartDto updateCard(CartDto cartDto);
}

package com.example.checkit.service;

import com.example.checkit.dto.CardDto;
import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.PurchaseLineDto;

public interface CardService {

    CardDto createCard(PurchaseLineDto purchaseLineDto, ClientDto clientDto);

    CardDto updateCard(CardDto cardDto);
}

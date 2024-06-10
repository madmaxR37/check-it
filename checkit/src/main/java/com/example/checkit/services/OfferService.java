package com.example.checkit.services;

import com.example.checkit.dtos.OfferDto;

public interface OfferService {
    void createOffer(Long cartId, OfferDto offerDto);
}

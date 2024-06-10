package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.OfferDto;
import com.example.checkit.models.Offer;

public class OfferMapper {

    public static Offer offerDtoToOffer(OfferDto offerDto){
        return new Offer().setValue(offerDto.getOfferValue());
    }

    public static OfferDto offerToOfferDto(Offer offer){
        return  new OfferDto()
                .setCartDto(CartMapper.cartToCartDto(offer.getCart()))
                .setOfferValue(offer.getValue())
                .setId(offer.getId());
    }
}

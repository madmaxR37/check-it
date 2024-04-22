package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CardDto;
import com.example.checkit.model.Card;

public class CardMapper {

    public static CardDto cardtoCardDto(Card card){
        return new CardDto()
                .setId(card.getId())
                .setIsActiveStatus(card.getIsActiveStatus())
                .setTotalItemsCost(card.getTotalItemsCost());

    }

    public static Card cardDtoToCard(CardDto cardDto){
        return new Card()
                .setId(cardDto.getId())
                .setIsActiveStatus(cardDto.getIsActiveStatus())
                .setTotalItemsCost(cardDto.getTotalItemsCost());

    }

    // TODO map purchase lines field
}

package com.example.checkit.dto.mappers;

import com.example.checkit.dto.CardDto;
import com.example.checkit.model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardMapper {

    public static List<CardDto> cardsToCardDtos(List<Card> cards){

        List<CardDto> listDtos = new ArrayList<>();

        for(Card card: cards){
            CardDto cardDto = new CardDto();
            cardDto
                    .setId(card.getId())
                    .setName(card.getName())
                    .setIsActiveStatus(card.getIsActiveStatus())
                    .setTotalItemsCost(card.getTotalItemsCost())
                    .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(card.getPurchaseLine()));
            listDtos.add(cardDto);
        }

        return listDtos ;

    }

    public static List<Card> cardDtosToCards(List<CardDto> cardDtos){

        List<Card> cards = new ArrayList<>();
                for (CardDto cardDto: cardDtos){
                    Card card = new Card();
                    card
                            .setId(cardDto.getId())
                            .setName(card.getName())
                            .setIsActiveStatus(cardDto.getIsActiveStatus())
                            .setTotalItemsCost(cardDto.getTotalItemsCost())
                            .setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(cardDto.getPurchaseLineDto()));
                    cards.add(card);
                }


        return cards;

    }
    public static Card cardDtoToCard(CardDto cardDto){
        return new Card()
                .setId(cardDto.getId())
                .setClient(ClientMapper.clientDtoToClient(cardDto.getClientDto()))
                .setIsActiveStatus(cardDto.getIsActiveStatus())
                .setTotalItemsCost(cardDto.getTotalItemsCost())
                .setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(cardDto.getPurchaseLineDto()));
    }

    public static CardDto cardToCardDto(Card card){
        return new CardDto()
                .setId(card.getId())
                .setClientId(ClientMapper.clientToClientDto(card.getClient()).getId())
                .setIsActiveStatus(card.getIsActiveStatus())
                .setTotalItemsCost(card.getTotalItemsCost())
                .setPurchaseLineDto(PurchaseLineMapper.purchaseLineToPurchaseLineDtos(card.getPurchaseLine()));
    }
}

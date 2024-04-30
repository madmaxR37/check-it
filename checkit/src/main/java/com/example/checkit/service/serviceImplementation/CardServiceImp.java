package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CardDto;
import com.example.checkit.dto.ClientDto;
import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.dto.mappers.CardMapper;
import com.example.checkit.dto.mappers.PurchaseLineMapper;
import com.example.checkit.model.Card;
import com.example.checkit.model.Client;
import com.example.checkit.model.Item;
import com.example.checkit.model.PurchaseLine;
import com.example.checkit.repository.*;
import com.example.checkit.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImp implements CardService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PurchaseLineRepository purchaseLineRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public CardDto createCard(PurchaseLineDto purchaseLineDto, ClientDto clientDto) {
        Optional<Item> item = itemRepository.findById(purchaseLineDto.getItemDto().getId());
        Optional<Client> client = clientRepository.findById(clientDto.getId());
        if (client.isPresent()){
            if(item.isPresent()){
                Item itemModel = item.get();
                if(itemModel.getQuantity()>=purchaseLineDto.getQuantity()){
                    purchaseLineRepository.save(PurchaseLineMapper.purchaseLineDtoToPurchaseLine(purchaseLineDto));
                    Optional<Card> cardOptional = cardRepository.findByName(purchaseLineDto.getItemDto().getSellerDto().getFirstname()+'#'+purchaseLineDto.getItemDto().getSellerDto().getId()+'#'+clientDto.getId());
                    Card card;
                    if (cardOptional.isPresent()){
                        card = cardOptional.get();
                        List<PurchaseLineDto> purchaseLineDtos = PurchaseLineMapper.purchaseLineToPurchaseLineDtos(card.getPurchaseLine()) ;
                        purchaseLineDtos.add(purchaseLineDto);
                        float sum = 0;
                        int totalItems=0;
                        for (PurchaseLineDto dto: purchaseLineDtos){
                            sum += dto.getPrice();
                            totalItems+= dto.getQuantity();
                        }
                            card
                                .setTotalItemsCost(sum)
                                .setTotalItemsQuantity(totalItems);
                        card.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos));

                    }else {
                        card = new Card();
                        List<PurchaseLineDto> purchaseLineDtos = new ArrayList<>();
                        purchaseLineDtos.add(purchaseLineDto);
                        float sum = 0;
                        int totalItems=0;
                        for (PurchaseLineDto dto: purchaseLineDtos){
                            sum += dto.getPrice();
                            totalItems+= dto.getQuantity();
                        }
                        card.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos))
                                .setName(purchaseLineDto.getItemDto().getSellerDto().getFirstname()+'#'+purchaseLineDto.getItemDto().getSellerDto().getId()+'#'+clientDto.getId())
                                .setIsActiveStatus(true)
                                .setTotalItemsCost(sum)
                                .setTotalItemsQuantity(totalItems);

                    }
                    cardRepository.save(card);
                    return CardMapper.cardToCardDto(card);
                }
            }

        }

        return null;
    }

    @Override
    public CardDto updateCard(CardDto cardDto) {
        Optional<Card> cardOptional = cardRepository.findByName(cardDto.getName());
        Card card;
        if (cardOptional.isPresent()){
            card = CardMapper.cardDtoToCard(cardDto);
            List<PurchaseLine> purchaseLines= card.getPurchaseLine();
            float sum =0;
            int totalItems=0;
            for(PurchaseLine purchaseLine: purchaseLines){
                sum+=purchaseLine.getPrice();
                totalItems+=purchaseLine.getQuantity();
            }
                card
                    .setTotalItemsCost(sum)
                    .setTotalItemsQuantity(totalItems);
            cardRepository.save(card);
            return CardMapper.cardToCardDto(card);
        }
        return null;
    }
}

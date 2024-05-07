package com.example.checkit.service.serviceImplementation;

import com.example.checkit.dto.CartDto;
import com.example.checkit.dto.PurchaseLineDto;
import com.example.checkit.dto.mappers.CartMapper;
import com.example.checkit.dto.mappers.PurchaseLineMapper;
import com.example.checkit.model.Cart;
import com.example.checkit.model.Client;
import com.example.checkit.model.Item;
import com.example.checkit.model.PurchaseLine;
import com.example.checkit.repository.*;
import com.example.checkit.service.CartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    private final ItemRepository itemRepository;

    private final PurchaseLineRepository purchaseLineRepository;

    private final CartRepository cartRepository;

    private final ClientRepository clientRepository;

    public CartServiceImp(ItemRepository itemRepository,
                          PurchaseLineRepository purchaseLineRepository,
                          CartRepository cartRepository,
                          ClientRepository clientRepository){
        this.itemRepository=itemRepository;
        this.purchaseLineRepository=purchaseLineRepository;
        this.cartRepository=cartRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    public CartDto createCard(PurchaseLineDto purchaseLineDto, Long clientId) {
        Optional<Item> item = itemRepository.findById(purchaseLineDto.getItemDto().getId());
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()){
            if(item.isPresent()){
                Item itemModel = item.get();
                if(itemModel.getQuantity()>=purchaseLineDto.getQuantity()){
                    purchaseLineRepository.save(PurchaseLineMapper.purchaseLineDtoToPurchaseLine(purchaseLineDto));
                    Optional<Cart> cartOptional = cartRepository.findByName(purchaseLineDto.getItemDto().getSellerDto().getFirstname()+'#'+purchaseLineDto.getItemDto().getSellerDto().getId()+'#'+clientId);
                    Cart cart;
                    if (cartOptional.isPresent()){
                        cart = cartOptional.get();
                        List<PurchaseLineDto> purchaseLineDtos = PurchaseLineMapper.purchaseLineToPurchaseLineDtos(cart.getPurchaseLine()) ;
                        purchaseLineDtos.add(purchaseLineDto);
                        float sum = 0;
                        int totalItems=0;
                        for (PurchaseLineDto dto: purchaseLineDtos){
                            sum += dto.getPrice();
                            totalItems+= dto.getQuantity();
                        }
                            cart
                                .setTotalItemsCost(sum)
                                .setTotalItemsQuantity(totalItems);
                        cart.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos));


                    }else {
                        cart = new Cart();
                        List<PurchaseLineDto> purchaseLineDtos = new ArrayList<>();
                        purchaseLineDtos.add(purchaseLineDto);
                        float sum = 0;
                        int totalItems=0;
                        for (PurchaseLineDto dto: purchaseLineDtos){
                            sum += dto.getPrice();
                            totalItems+= dto.getQuantity();
                        }
                        cart.setPurchaseLine(PurchaseLineMapper.purchaseLineDtoToPurchaseLines(purchaseLineDtos))
                                .setName(purchaseLineDto.getItemDto().getSellerDto().getFirstname()+'#'+purchaseLineDto.getItemDto().getSellerDto().getId()+'#'+clientId)
                                .setIsActiveStatus(true)
                                .setTotalItemsCost(sum)
                                .setTotalItemsQuantity(totalItems);

                    }
                    cartRepository.save(cart);
                    return CartMapper.cardToCardDto(cart);
                }
            }

        }

        return null;
    }

    @Override
    public CartDto updateCard(CartDto cartDto) {
        Optional<Cart> cardOptional = cartRepository.findByName(cartDto.getName());
        Cart cart;
        if (cardOptional.isPresent()){
            cart = CartMapper.cardDtoToCard(cartDto);
            List<PurchaseLine> purchaseLines= cart.getPurchaseLine();
            float sum =0;
            int totalItems=0;
            for(PurchaseLine purchaseLine: purchaseLines){
                sum+=purchaseLine.getPrice();
                totalItems+=purchaseLine.getQuantity();
            }
                cart
                    .setTotalItemsCost(sum)
                    .setTotalItemsQuantity(totalItems);
            cartRepository.save(cart);
            return CartMapper.cardToCardDto(cart);
        }
        return null;
    }
}

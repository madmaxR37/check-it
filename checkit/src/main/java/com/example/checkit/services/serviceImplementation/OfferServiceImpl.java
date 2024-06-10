package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.OfferDto;
import com.example.checkit.dtos.mappers.OfferMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Cart;
import com.example.checkit.models.Offer;
import com.example.checkit.repositories.CartRepository;
import com.example.checkit.repositories.OfferRepository;
import com.example.checkit.services.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final CartRepository cartRepository;

    public OfferServiceImpl(OfferRepository offerRepository, CartRepository cartRepository) {
        this.offerRepository = offerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void createOffer(Long cartId, OfferDto offerDto) {

        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isEmpty()){
            throw  new EntityNotFoundException("this cart does not exist", HttpStatus.NOT_FOUND);
        }
        Cart cart = cartOptional.get();
        Offer offer = OfferMapper.offerDtoToOffer(offerDto);
        offer.setCart(cart)
                .setSeller(cart.getPurchaseLine().get(0).getItem().getSeller());
        offerRepository.save(offer);
    }
}

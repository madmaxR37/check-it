package com.example.checkit.services.serviceImplementation;

import com.example.checkit.dtos.PurchaseLineDto;
import com.example.checkit.dtos.mappers.PurchaseLineMapper;
import com.example.checkit.exceptions.EntityNotFoundException;
import com.example.checkit.models.Item;
import com.example.checkit.models.PurchaseLine;
import com.example.checkit.repositories.ItemRepository;
import com.example.checkit.repositories.PurchaseLineRepository;
import com.example.checkit.services.PurchaseLineService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PurchaseLineServiceImp implements PurchaseLineService {

    private final ItemRepository itemRepository;

    private final PurchaseLineRepository purchaseLineRepository;

    public PurchaseLineServiceImp(ItemRepository itemRepository, PurchaseLineRepository purchaseLineRepository) {
        this.itemRepository = itemRepository;
        this.purchaseLineRepository = purchaseLineRepository;
    }

    @Override
    public Long createPurchaseLine(Long itemId, PurchaseLineDto purchaseLineDto) {
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()){
            Item itemModel = item.get();
            PurchaseLine purchaseLine =PurchaseLineMapper.purchaseLineDtoToPurchaseLine(purchaseLineDto);
            purchaseLine.setItem(itemModel)
                    .setPrice(setPrice(itemModel.getUnitPrice(), purchaseLineDto.getQuantity()));
             purchaseLineRepository.save(purchaseLine);
            return purchaseLine.getId();
        }
        throw new EntityNotFoundException("this item doesn't exist", HttpStatus.NOT_FOUND);
    }

    @Override
    public void deletePurchaseLine(Long purchaseLineId) {

    }

    public float setPrice(float unitPrice, int quantity ){
        return unitPrice*quantity;
    }
}
